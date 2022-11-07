package fr.gdai.mybatis;

import fr.gdai.mybatis.mapper.UserMapper;
import fr.gdai.mybatis.pojo.User;
import fr.gdai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MyBatisTest {
    @Test
    public void testMyBatis() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("myBatis-config.xml");
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory
        SqlSessionFactory ssf = ssfb.build(is);
        // 获取SqlSession, true为开启自动提交事务
        SqlSession sqlSession = ssf.openSession(true);
        // 获取Mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int result = userMapper.insertUser();
        System.out.println(result);

//        // 提交事务
//        sqlSession.commit();
    }

    @Test
    public void testUpdateUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("myBatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = ssf.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.updateUser());
    }

    @Test
    public void testDeleteUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("myBatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = ssf.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.deleteUser());
    }

    @Test
    public void testSelectUserBtId() throws IOException {
        InputStream is = Resources.getResourceAsStream("myBatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
        // 以上操作是重复的，所以我们将其拆分出来：fr.gdai.mybatis.utils.SqlSessionUtils
        SqlSession sqlSession = ssf.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.selectUserById(1).toString());
    }

    @Test
    public void testSelectUserBtIdToMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        // 获取Mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> resultMap = userMapper.selectUserByIdToMap(1);
        System.out.println(resultMap);
    }

    @Test
    public void testSelectAllUsers() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAllUser();
        for (User u:userList) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void testSelectAllUsersToListMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String, Object>> userList = userMapper.selectAllUserToListMap();
        for (Map<String, Object> u:userList) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void testSelectAllUsersToMapMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Map<String, Object>> userMap = userMapper.selectAllUserToMapMap();
        System.out.println(userMap);
    }

    @Test
    public void testSelectUserCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.selectUserCount();
        System.out.println("记录数："+count);
    }

    @Test
    public void testGetUserByUsername() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserByUsername("gdai");
        System.out.println(user.toString());
    }

    @Test
    public void testSelectUserByUsernameAndPassword() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserByIdAndPassword("admin","admin");
        System.out.println(user.toString());
    }

    @Test
    public void testSelectUserByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "gdai");
        map.put("password", "admin");
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserByMap(map);
        System.out.println(user.toString());
    }

    @Test
    public void testSelectUserByNameLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList= userMapper.selectUserByNameLike("d");
        for (User u:userList) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void testSelectUserByAnnotation() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserByAnnotation("tom","123456");
        System.out.println(user.toString());
    }
    @Test
    public void testInsertUserByEntity() {
        User user = new User(3,"tom", "123456", 22, "男", "tom@tom.com");
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insertUserByEntity(user);
    }

}