package com.linshi.service;


import com.linshi.domain.Employee;

import java.util.List;

public interface IEmployeeService {

    int delete(Long id);

    int save(Employee record);

    Employee get(Long id);

    List<Employee> list();

    int update(Employee record);
}
