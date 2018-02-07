package com.linshi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter@Setter
public class Employee {
    public static final Integer STATE_LEAVE = 1;

    private Long id;

    private String username;

    private String realname;

    private String password;

    private String tel;

    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputTime;

    private int state;

    private boolean admin;

}