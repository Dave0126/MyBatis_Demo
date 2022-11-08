package fr.gdai.mybatis.mapper;

import fr.gdai.mybatis.pojo.Dept;
import fr.gdai.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DeptMapper {

    // 通过deptId查询部门
    @Select("select * from t_dept where dept_id = #{deptId}")
    @Results( id = "deptResultMap", value={
            @Result(id = true, property="deptId", column="dept_id"),
            @Result(property="deptName", column="dept_name"),
    })
    Dept getDeptByDeptId(@Param("deptId") int deptId);


    // 获得部门以及部门中所有员工的信息
    Dept getDeptAndEmpsByDeptId(@Param("deptId") int deptId);

    // 【分布查询】部门以及部门中所有员工的信息
    @Select("select * from t_dept where dept_id = #{deptId}")
    @Results( id="deptAndEmpResultMap_One2Many_Step", value={
            @Result(id = true, property="deptId", column="dept_id"),
            @Result(property="deptName", column="dept_name"),
            @Result(property = "emps",
                    column = "dept_id",
                    javaType = List.class,
                    many = @Many(select = "fr.gdai.mybatis.mapper.EmpMapper.getEmpsListByDeptId")
            )
    })
    Dept getDeptAndEmpsByDeptIdStep(@Param("deptId") int deptId);
}
