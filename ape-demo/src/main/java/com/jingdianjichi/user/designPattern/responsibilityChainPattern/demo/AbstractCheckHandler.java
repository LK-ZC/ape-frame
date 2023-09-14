package com.jingdianjichi.user.designPattern.responsibilityChainPattern.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 功能：
 *
 * @author zhenghang
 * @date 2023/6/10
 */
@Component
public abstract class AbstractCheckHandler {

    /**
     * 当前处理器持有下一个处理器的引用
     */
    @Getter
    @Setter
    protected AbstractCheckHandler nextHandler;

    /**
     * 处理器配置
     */
    @Getter
    @Setter
    protected ProductCheckHandlerConfig config;

    /**
     * 处理器执行方法
     */
    public abstract String handle(String param);

    /**
     * 链路传递
     *
     */
    protected String next(String param) {
        // 没有下一个处理器 结束
        if (Objects.isNull(nextHandler)) {
            return "true";
        }
        return nextHandler.next(param);
    }

}
