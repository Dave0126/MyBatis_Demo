package fr.gdai.mybatis.mapper;

import fr.gdai.mybatis.config.SpringConfig;
import fr.gdai.mybatis.pojo.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class EmpMapperTest {

    @Test
    public void getAllEmp() {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        EmpMapper empMapper = ctx.getBean(EmpMapper.class);
        List<Emp> empList = empMapper.getAllEmp();
        for (Emp e:empList) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void getAllEmpAndDept() {
    }

    @Test
    public void getEmpAndDeptStepByStep() {
    }

    @Test
    public void getEmpsListByDeptId() {
    }
}