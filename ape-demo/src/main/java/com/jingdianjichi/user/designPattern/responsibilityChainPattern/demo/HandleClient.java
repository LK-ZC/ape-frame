package com.jingdianjichi.user.designPattern.responsibilityChainPattern.demo;

import org.springframework.stereotype.Component;

/**
 * 执行处理器链路
 *
 * @author zhenghang
 * @date 2023/6/10
 */
@Component
public class HandleClient {
    public String executeChain(AbstractCheckHandler handler, String param) {
        return handler.handle(param);
    }
}
