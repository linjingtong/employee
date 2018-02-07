package com.linshi.service;


import com.linshi.domain.Employee;
import com.linshi.query.EmployeeQueryObject;
import com.linshi.query.PageResult;

import java.util.List;

public interface IEmployeeService {

    int delete(Long id);

    int save(Employee record);

    Employee get(Long id);

    List<Employee> list();

    int update(Employee record);

    PageResult query(EmployeeQueryObject qo);

    void leave(Long id);
}
