package com.jumota.uoolo.auth.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Demo {
    private Integer id;
    private Date createTime;
    private String delFlag;
    private String author;
    private String title;
    private String content;
}
