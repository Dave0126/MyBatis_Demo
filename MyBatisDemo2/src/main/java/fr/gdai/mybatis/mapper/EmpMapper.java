package fr.gdai.mybatis.mapper;

import fr.gdai.mybatis.pojo.Dept;
import fr.gdai.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmpMapper {

    // 查询所有的员工信息
    @Select("select * from t_emp")
    @Results( id="empResultMap", value={
            @Result (id = true, property="empId", column="emp_id"),
            @Result (property="empName", column="emp_name"),
            @Result (property="empAge", column="emp_age"),
            @Result (property="empGender", column="emp_gender"),
            @Result (property="empEmail", column="emp_email"),
    })
    List<Emp> getAllEmp();

    // 级联 - 查询所有的员工信息及其部门信息
    @Select("select * from t_emp left join t_dept on t_emp.dept_id = t_dept.dept_id")
    @Results( id="empAndDeptResultMap_Many2One_Cascade", value={
            @Result (id = true, property="empId", column="emp_id"),
            @Result (property="empName", column="emp_name"),
            @Result (property="empAge", column="emp_age"),
            @Result (property="empGender", column="emp_gender"),
            @Result (property="empEmail", column="emp_email"),
            @Result (property="dept.deptId", column="dept_id"),
            @Result (property="dept.deptName", column="dept_name"),
    })
    List<Emp> getAllEmpAndDept_Cascade();

    // Association - 查询所有的员工信息及其部门信息
    @Select("select * from t_emp")
    @Results( id="empAndDeptResultMap_Many2One_Association", value={
            @Result (id = true, property="empId", column="emp_id"),
            @Result (property="empName", column="emp_name"),
            @Result (property="empAge", column="emp_age"),
            @Result (property="empGender", column="emp_gender"),
            @Result (property="empEmail", column="emp_email"),
            @Result (javaType = Dept.class, property="dept", column="dept_id",
                    one=@One(select = "fr.gdai.mybatis.mapper.DeptMapper.getDeptByDeptId")),
    })
    List<Emp> getAllEmpAndDept_Association();

    // 【分布查询】按id查询的员工信息及其部门信息
    @Select("select * from t_emp where emp_id = #{empId}")
    @Results( id="empAndDeptResultMap_Many2One_StepByStep", value={
            @Result (id = true, property="empId", column="emp_id"),
            @Result (property="empName", column="emp_name"),
            @Result (property="empAge", column="emp_age"),
            @Result (property="empGender", column="emp_gender"),
            @Result (property="empEmail", column="emp_email"),
            @Result (javaType = Dept.class, property="dept", column="dept_id",
                    one=@One(select = "fr.gdai.mybatis.mapper.DeptMapper.getDeptByDeptId")),
    })
    Emp getEmpAndDeptStepByStep(@Param("empId") int empId);

    // 根据dept_id查询员工信息
    @Select("select * from t_emp where dept_id = #{DeptId}")
    @ResultMap("empResultMap")
    List<Emp> getEmpsListByDeptId(@Param("DeptId") int DeptId);


}
