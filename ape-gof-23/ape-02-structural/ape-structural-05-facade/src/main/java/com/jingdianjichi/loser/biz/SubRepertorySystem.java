package com.jingdianjichi.loser.biz;

import com.jingdianjichi.loser.core.Component;

@Component
public class SubRepertorySystem {

    public void check(Order order) {
        int num = 1000;
        System.out.println("检查库存 " + num);
    }

    public void order(Order order) {
        System.out.println("扣减库存 " + order.getGoodNum());
    }

}
