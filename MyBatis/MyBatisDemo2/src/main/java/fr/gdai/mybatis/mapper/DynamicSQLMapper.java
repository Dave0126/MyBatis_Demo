package fr.gdai.mybatis.mapper;

import fr.gdai.mybatis.pojo.Dept;
import fr.gdai.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    // <if>标签实现若干条件查询
    List<Emp> getEmpByConditions(Emp emp);
    // <where>标签实现若干条件查询
    List<Emp> getEmpByConditionsWhereLabel(Emp emp);
    // <trim>标签实现若干条件查询
    List<Emp> getEmpByConditionsTrimLabel(Emp emp);
    // <choose>标签实现单个符合条件查询
    List<Emp> getEmpByConditionsChooseLabel(Emp emp);
    // 批量添加
    int insertManyEmps(@Param("emps") List<Emp> emps);
    // 批量搜索
    List<Emp> selectManyEmps(@Param("empIds") List<Integer> empIds);
    // <sql>标签：所有部门的信息
    List<Dept> getAllDept();

}
