package com.jingdianjichi.loser.biz;

import com.jingdianjichi.loser.core.Component;

@Component
public class SubPaySystem {

    public void pay(Order order) {
        System.out.println("支付订单 " + order);
    }

}
