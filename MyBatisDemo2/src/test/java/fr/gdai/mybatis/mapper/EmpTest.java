package fr.gdai.mybatis.mapper;

import fr.gdai.mybatis.pojo.Emp;
import fr.gdai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmpTest {

    @Test
    public void testGetAllEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.getAllEmp();
        for (Emp e:empList) {
            System.out.println(e);
        }
    }

    @Test
    public void testGetAllEmpAndDept_Cascade() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.getAllEmpAndDept_Cascade();
        for (Emp e:empList) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void testGetAllEmpAndDept_Association() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.getAllEmpAndDept_Association();
        for (Emp e:empList) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void testGetEmpAndDeptStepByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp result = empMapper.getEmpAndDeptStepByStep(1);
        System.out.println(result);
    }

    @Test
    public void testGetEmpsListByDeptId() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> result = empMapper.getEmpsListByDeptId(1);
        for (Emp e:result) {
            System.out.println(e.toString());
        }
    }
}