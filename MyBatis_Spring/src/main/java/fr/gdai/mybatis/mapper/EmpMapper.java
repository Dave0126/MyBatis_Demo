package fr.gdai.mybatis.mapper;

import fr.gdai.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpMapper {

    // 查询所有的员工信息
    List<Emp> getAllEmp();

    // 查询所有的员工信息及其部门信息
    List<Emp> getAllEmpAndDept();

    // 【分布查询】按id查询的员工信息及其部门信息
    Emp getEmpAndDeptStepByStep(@Param("empId") int empId);

    // 根据dept_id查询员工信息
    List<Emp> getEmpsListByDeptId(@Param("DeptId") int DeptId);


}
