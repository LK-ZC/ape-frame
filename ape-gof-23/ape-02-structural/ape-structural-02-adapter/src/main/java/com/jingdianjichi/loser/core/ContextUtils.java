package com.jingdianjichi.loser.core;

import java.util.List;

public class ContextUtils {

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public static <T> T getBean(Class<T> targetClass) {
        return applicationContext.getBean(targetClass);
    }

    public static <T> List<T> getBeans(Class<T> targetClass) {
        return applicationContext.getBeans(targetClass);
    }


    private ContextUtils() {
    }

}
