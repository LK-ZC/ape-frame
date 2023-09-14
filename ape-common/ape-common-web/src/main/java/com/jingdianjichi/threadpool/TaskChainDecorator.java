package com.jingdianjichi.threadpool;

import org.springframework.core.task.TaskDecorator;

import java.util.Iterator;
import java.util.List;

/**
 * @author: Henrik.Zhou
 * @date: 2023/7/20 13:18
 */
public class TaskChainDecorator implements TaskDecorator {

    private final List<ThreadPoolTaskDecorator> decorators;

    public TaskChainDecorator(List<ThreadPoolTaskDecorator> decorators) {
        this.decorators = decorators;
    }

    @Override
    public Runnable decorate(Runnable runnable) {
        return decoratorRunnable(decorators.iterator(),runnable);
    }

    Runnable decoratorRunnable(Iterator<ThreadPoolTaskDecorator> decorators,Runnable runnable) {
        Runnable delegate = runnable;
        while (decorators.hasNext()) {
            delegate = decorators.next().decorator(delegate);
        }
        return delegate;
    }

}
