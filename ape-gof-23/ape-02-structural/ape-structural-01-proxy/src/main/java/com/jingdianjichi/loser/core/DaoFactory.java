package com.jingdianjichi.loser.core;

import java.lang.reflect.Proxy;

public class DaoFactory {

    public <T> T getData(Class<T> tClass) {
        Class[] classes = {tClass};
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(), classes, new DaoProxy());
    }

}
