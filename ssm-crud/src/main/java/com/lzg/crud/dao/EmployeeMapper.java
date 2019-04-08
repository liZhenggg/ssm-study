package com.lzg.crud.dao;

import com.lzg.crud.bean.Employee;
import com.lzg.crud.bean.EmployeeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer empId);

    /**
     * 查询员工和部门信息
     *
     * @param example
     * @return
     */
    List<Employee> selectByExampleWithDept(EmployeeExample example);

    /**
     * 查询员工和部门信息
     *
     * @param empId
     * @return
     */
    Employee selectByPrimaryKeyWithDept(Integer empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}