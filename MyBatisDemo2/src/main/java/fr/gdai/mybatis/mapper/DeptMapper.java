package fr.gdai.mybatis.mapper;

import fr.gdai.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    // 通过deptId查询部门
    Dept getDeptBtDeptId(@Param("deptId") int deptId);

    // 获得部门以及部门中所有员工的信息
    Dept getDeptAndEmpsByDeptId(@Param("deptId") int deptId);

    // 【分布查询】部门以及部门中所有员工的信息
    Dept getDeptAndEmpsByDeptIdStep(@Param("deptId") int deptId);
}
