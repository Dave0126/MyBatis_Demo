package fr.gdai.mybatis.mapper;

import fr.gdai.mybatis.pojo.Dept;
import fr.gdai.mybatis.pojo.Emp;
import fr.gdai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DynamicSQLMapperTest {
    @Test
    public void testGetEmpByConditions() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> result = mapper.getEmpByConditions(
                new Emp(null, "gdai", 24, "男",null, null));
        System.out.println(result);
    }

    @Test
    public void testGetEmpByConditionsWhereLabel() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> result = mapper.getEmpByConditionsWhereLabel(
                new Emp(null, "gdai", 24, "男",null, null));
        System.out.println(result);
    }

    @Test
    public void testGetEmpByConditionsTrimLabel() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> result = mapper.getEmpByConditionsTrimLabel(
                new Emp(null, "gdai", 24, "男",null, null));
        System.out.println(result);
    }

    @Test
    public void testGetEmpByConditionsChooseLabel() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> result = mapper.getEmpByConditionsChooseLabel(
                new Emp(null, "gdai", 24, "男",null, null));
        System.out.println(result);
        System.out.println("---------------------otherwise-------------------");
        List<Emp> result_otherwise = mapper.getEmpByConditionsChooseLabel(
                new Emp(null, "", null, "","", null));
        for (Emp e:result_otherwise) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void testSelectManyEmps() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Emp> resluts = mapper.selectManyEmps(list);
        for (Emp e:resluts) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void testInsertManyEmps() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp(null, "calioppe", 22, "女", "calioppe@calioppe.com",deptMapper.getDeptBtDeptId(1)));
        empList.add(new Emp(null, "david", 22, "男", "david@david.com", deptMapper.getDeptBtDeptId(1)));
        empList.add(new Emp(null, "alex", 23, "男", "alex@alex.com",deptMapper.getDeptBtDeptId(2)));
        int result = dynamicSQLMapper.insertManyEmps(empList);
        System.out.println(result);
    }

    @Test
    public void testGetAllDept() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Dept> results = dynamicSQLMapper.getAllDept();
        for (Dept d:results) {
            System.out.println(d.toString());
        }
    }
}