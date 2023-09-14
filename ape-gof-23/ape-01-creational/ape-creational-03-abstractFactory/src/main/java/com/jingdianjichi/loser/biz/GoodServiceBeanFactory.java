package com.jingdianjichi.loser.biz;

import com.jingdianjichi.loser.core.BeanFactory;
import com.jingdianjichi.loser.core.Server;

public class GoodServiceBeanFactory implements BeanFactory {

    @Override
    public Server getBean() {
        return new GoodService();
    }

}
