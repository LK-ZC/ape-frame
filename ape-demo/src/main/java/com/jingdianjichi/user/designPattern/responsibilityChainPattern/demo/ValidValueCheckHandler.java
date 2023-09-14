package com.jingdianjichi.user.designPattern.responsibilityChainPattern.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 有效值校验
 *
 * @author zhenghang
 * @date 2023/6/10
 */
@Slf4j
@Component
public class ValidValueCheckHandler extends AbstractCheckHandler{
    @Override
    public String handle(String param) {
        log.info("Valid Value Check Success" + param);
        return super.next("1");
    }
}
