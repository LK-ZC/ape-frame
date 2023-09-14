package com.jingdianjichi.loser.biz;

import com.jingdianjichi.loser.core.Component;

@Component
public class SubOrderSystem {

    public void createOrder(Order order) {
        System.out.println("生成订单 " + order);
    }

}
