package fr.gdai.mybatis.mapper;

import fr.gdai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DeptMapperTest {

    @Test
    public void testGetDeptByDeptId() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        System.out.println(deptMapper.getDeptByDeptId(1));
    }

    @Test
    public void testGetDeptAndEmpsByDeptId() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        System.out.println(deptMapper.getDeptAndEmpsByDeptId(1));
    }

    @Test
    public void testGetDeptAndEmpsByDeptIdStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        System.out.println(deptMapper.getDeptAndEmpsByDeptIdStep(1));
    }
}