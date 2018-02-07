package com.linshi.service.impl;

import com.linshi.domain.Employee;
import com.linshi.mapper.EmployeeMapper;
import com.linshi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int delete(Long id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int save(Employee record) {
        return employeeMapper.insert(record);
    }

    @Override
    public Employee get(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> list() {
        return employeeMapper.selectAll();
    }

    @Override
    public int update(Employee record) {
        return employeeMapper.updateByPrimaryKey(record);
    }
}
