package com.jingdianjichi.loser.biz;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUser implements Serializable {

    private Long id;

    private String name;

    private Integer age;

}