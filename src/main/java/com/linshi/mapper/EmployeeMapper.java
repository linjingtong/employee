package com.linshi.mapper;

import com.linshi.domain.Employee;
import com.linshi.query.EmployeeQueryObject;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    int queryCount(EmployeeQueryObject qo);

    List<?> queryData(EmployeeQueryObject qo);

    void updateStateToLeave(Long id);
}