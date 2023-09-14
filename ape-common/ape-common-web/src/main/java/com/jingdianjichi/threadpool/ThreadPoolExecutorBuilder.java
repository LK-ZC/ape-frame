package com.jingdianjichi.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.List;

/**
 * @author: Henrik.Zhou
 * @date: 2023/7/20 13:05
 */
@Slf4j
public class ThreadPoolExecutorBuilder {

    private List<ThreadPoolTaskDecorator> decorators;

    public ThreadPoolExecutorBuilder(List<ThreadPoolTaskDecorator> decorators) {
        this.decorators = decorators;
    }

    public ThreadPoolTaskExecutor build(ThreadPoolExecutorProperty threadPoolExecutorProperty) {
        final String threadName = threadPoolExecutorProperty.getThreadName();
        if (StringUtils.isBlank(threadName)) {
            throw new IllegalArgumentException("ThreadPoolExecutorProperty 线程池配置name不能为空！");
        }
        log.info("初始化线程池配置:{}", threadPoolExecutorProperty);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        if (CollectionUtils.isNotEmpty(decorators)) {
            executor.setTaskDecorator(new TaskChainDecorator(decorators));
        }
        executor.setBeanName(threadPoolExecutorProperty.getThreadName());
        executor.setCorePoolSize(threadPoolExecutorProperty.getCorePoolSize());
        executor.setMaxPoolSize(threadPoolExecutorProperty.getMaxPoolSize());
        executor.setQueueCapacity(threadPoolExecutorProperty.getQueueCapacity());
        executor.setThreadNamePrefix(threadName + "-");
        executor.setKeepAliveSeconds(threadPoolExecutorProperty.getKeepAliveSeconds());
        executor.setWaitForTasksToCompleteOnShutdown(threadPoolExecutorProperty.getWaitForTasksToCompleteOnShutdown());
        executor.setThreadPriority(threadPoolExecutorProperty.getThreadPriority());
        executor.setRejectedExecutionHandler(threadPoolExecutorProperty.getRejectedExecutionHandler());
        executor.setAllowCoreThreadTimeOut(threadPoolExecutorProperty.getAllowCoreThreadTimeOut());
        executor.setAwaitTerminationSeconds(threadPoolExecutorProperty.getAwaitTerminationSeconds());
        executor.initialize();
        return executor;
    }

}
