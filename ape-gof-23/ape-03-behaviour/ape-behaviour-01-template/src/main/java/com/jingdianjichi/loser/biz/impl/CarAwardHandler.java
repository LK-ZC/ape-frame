package com.jingdianjichi.loser.biz.impl;

import com.jingdianjichi.loser.biz.AwardConfig;
import com.jingdianjichi.loser.biz.BaseAwardHandler;
import com.jingdianjichi.loser.core.Component;

@Component
public class CarAwardHandler extends BaseAwardHandler {

    @Override
    protected void doAwardCore(Long userId, AwardConfig config) {
        System.out.println("send car userId:" + userId + " " + config);
    }

    @Override
    protected int getAwardType() {
        return 2;
    }
}
