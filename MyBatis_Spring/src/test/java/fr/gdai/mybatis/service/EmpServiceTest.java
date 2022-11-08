package fr.gdai.mybatis.service;

import fr.gdai.mybatis.config.SpringConfig;
import fr.gdai.mybatis.pojo.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class EmpServiceTest {

    @Autowired
    private EmpService empService;

    @Test
    public void getAllEmp() {
        List<Emp> empList = empService.getAllEmp();
        for (Emp e:empList) {
            System.out.println(e.toString());
        }
    }
}