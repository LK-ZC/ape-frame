package com.jingdianjichi.loser.biz.impl;

import com.jingdianjichi.loser.biz.LoginMsg;
import com.jingdianjichi.loser.biz.TaskFilter;
import com.jingdianjichi.loser.core.Component;

import java.util.Objects;

@Component
public class LoginTaskFilter implements TaskFilter<LoginMsg> {

    @Override
    public boolean doFilter(LoginMsg loginMsg) {
        return Objects.isNull(loginMsg) || Objects.isNull(loginMsg.getUserId());
    }
}
