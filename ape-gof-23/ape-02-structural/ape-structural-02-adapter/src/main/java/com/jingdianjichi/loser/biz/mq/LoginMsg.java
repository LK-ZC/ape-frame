package com.jingdianjichi.loser.biz.mq;

import lombok.Data;

import java.util.Date;

@Data
public class LoginMsg {

    private Long uid;

    private Date loginTime;

    private Boolean login;

}
