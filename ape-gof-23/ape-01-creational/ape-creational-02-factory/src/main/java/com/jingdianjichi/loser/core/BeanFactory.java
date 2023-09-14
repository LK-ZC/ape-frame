package com.jingdianjichi.loser.core;

/**
 * 工厂模式
 */
public class BeanFactory {

    /**
     * 通过简单工厂去获取一个bean
     */
    public static Server getBean(Class<? extends Server> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception ignore) {
        }
        return null;
    }

}
