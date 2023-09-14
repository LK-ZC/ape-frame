package com.jingdianjichi.threadpool;

/**
 * The interface Thread pool task decorator.
 *
 * @author: Henrik.Zhou
 * @date: 2023 /7/20 13:00
 */
public interface ThreadPoolTaskDecorator {

    /**
     * Decorator runnable.
     *
     * @param runnable the runnable
     * @return the runnable
     */
    Runnable decorator(Runnable runnable);
}
