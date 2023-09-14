package com.jingdianjichi.user.designPattern.responsibilityChainPattern.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 处理器配置类
 *
 * @author zhenghang
 * @date 2023/6/10
 */
@AllArgsConstructor
@Data
public class ProductCheckHandlerConfig {
    /**
     * 处理器bean的名称
     */
    private String handler;

    /**
     * 下一个处理器
     */
    private ProductCheckHandlerConfig next;

    /**
     * 是否降级
     */
    private Boolean down = Boolean.FALSE;
}
