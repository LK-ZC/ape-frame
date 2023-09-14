package com.jingdianjichi.loser.biz;

import com.jingdianjichi.loser.core.Autowired;
import com.jingdianjichi.loser.core.Component;

@Component
public class OrderFacade {

    @Autowired
    private SubRepertorySystem subRepertorySystem;
    @Autowired
    private SubPaySystem subPaySystem;
    @Autowired
    private SubOrderSystem subOrderSystem;

    public void order(Order order) {

        subRepertorySystem.check(order);
        subRepertorySystem.order(order);
        subOrderSystem.createOrder(order);
        subPaySystem.pay(order);

    }

}
