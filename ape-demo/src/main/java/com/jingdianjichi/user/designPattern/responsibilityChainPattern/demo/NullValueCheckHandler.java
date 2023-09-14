package com.jingdianjichi.user.designPattern.responsibilityChainPattern.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 空值校验
 *
 * @author zhenghang
 * @date 2023/6/10
 */
@Slf4j
@Component
public class NullValueCheckHandler extends AbstractCheckHandler {
    @Override
    public String handle(String param) {
        log.info("Not Null Value" + param);
        return super.next("1");
    }
}
