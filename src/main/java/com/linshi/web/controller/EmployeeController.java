package com.linshi.web.controller;

import com.linshi.domain.Employee;
import com.linshi.query.EmployeeQueryObject;
import com.linshi.query.PageResult;
import com.linshi.service.IEmployeeService;
import com.linshi.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/index")
    public String index() {
        return "employee";
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(EmployeeQueryObject qo) {
        PageResult pageResult = employeeService.query(qo);
        return pageResult;
    }


    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public AjaxResult saveOrUpdate(Employee employee) {
        AjaxResult ajaxResult = null;
        try {
            if (employee.getId() != null) {
                employeeService.update(employee);
            } else {
                employeeService.save(employee);
            }
            ajaxResult = new AjaxResult("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult = new AjaxResult(false, e.getMessage());
        }
        return ajaxResult;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult ajaxResult = null;
        try {
            employeeService.delete(id);
            ajaxResult = new AjaxResult("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult = new AjaxResult(false, e.getMessage());
        }
        return ajaxResult;
    }
    @RequestMapping("/leave")
    @ResponseBody
    public AjaxResult leave(Long id) {
        AjaxResult ajaxResult = null;
        try {
            employeeService.leave(id);
            ajaxResult = new AjaxResult("离职成功");
        } catch (Exception e) {
            e.printStackTrace();
            ajaxResult = new AjaxResult(false, e.getMessage());
        }
        return ajaxResult;
    }
}
