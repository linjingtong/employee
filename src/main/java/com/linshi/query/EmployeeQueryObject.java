package com.linshi.query;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class EmployeeQueryObject {
    //参数名称要和前台参数一致
    private Integer page = 1; //当前页
    private Integer rows = 10;  //每页条数

    public Integer getStart() {
        return (this.page - 1) * rows;
    }
}
