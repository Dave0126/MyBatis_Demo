package fr.gdai.mybatis.service;

import fr.gdai.mybatis.mapper.EmpMapper;
import fr.gdai.mybatis.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpMapper empMapper;

    public List<Emp> getAllEmp() {
        return empMapper.getAllEmp();
    }
}
