package com.linshi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter@Setter
public class Employee {
    private Long id;

    private String username;

    private String realname;

    private String password;

    private String tel;

    private String email;

    private Date inputTime;

    private int state;

    private boolean admin;

}