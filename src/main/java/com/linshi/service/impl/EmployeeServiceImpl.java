package com.linshi.service.impl;

import com.linshi.domain.Employee;
import com.linshi.mapper.EmployeeMapper;
import com.linshi.query.EmployeeQueryObject;
import com.linshi.query.PageResult;
import com.linshi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int delete(Long id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int save(Employee record) {
        record.setInputTime(new Date());
        record.setState(0);
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

    @Override
    public PageResult query(EmployeeQueryObject qo) {
        int count = employeeMapper.queryCount(qo);
        if (count == 0) {
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List<?> list = employeeMapper.queryData(qo);
        return new PageResult(count, list);
    }

    @Override
    public void leave(Long id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        //双重验证(前后台)
        if (employee == null) {
            throw new RuntimeException("该员工不存在");
        } else if (employee.getState() == Employee.STATE_LEAVE) {
            throw new RuntimeException("该员工已经离职");
        }
        employeeMapper.updateStateToLeave(id);
    }
}
