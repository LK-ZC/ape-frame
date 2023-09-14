package com.jingdianjichi.demo;

import com.alibaba.fastjson.JSON;
import com.jingdianjichi.user.DemoApplication;
import com.jingdianjichi.user.designPattern.responsibilityChainPattern.demo.AbstractCheckHandler;
import com.jingdianjichi.user.designPattern.responsibilityChainPattern.demo.ProductCheckHandlerConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * 责任链测试类
 *
 * @author zhenghang
 * @date 2023/6/10
 */
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class ResponsibilityChainPatternTest {

    @Resource
    private Map<String, AbstractCheckHandler> handlerMap;

    @Test
    public void paramCheck() {
        ProductCheckHandlerConfig handlerConfig = this.getHandlerConfig();
        AbstractCheckHandler handler = this.getHandler(handlerConfig);

        // 执行
        String result = executeChain(handler, "0");
        log.info("The chain success ");
    }

    private String executeChain(AbstractCheckHandler handler, String param) {
        return handler.handle(param);
    }

    private ProductCheckHandlerConfig getHandlerConfig() {
        // 可以放在配置中心
        String configJson = "{\"handler\":\"nullValueCheckHandler\",\"down\":true," +
                "\"next\":{\"handler\":\"ValidValueCheckHandler\",\"next\":null}}";
        return JSON.parseObject(configJson, ProductCheckHandlerConfig.class);
    }

    private AbstractCheckHandler getHandler(ProductCheckHandlerConfig config) {
        // 配置检查
        if (Objects.isNull(config)) {
            return null;
        }

        // 配置错误
        String handler = config.getHandler();
        if (StringUtils.isBlank(handler)) {
            return null;
        }

        // 配置了不存在的处理器
        AbstractCheckHandler abstractCheckHandler = handlerMap.get(config.getHandler());
        if (Objects.isNull(abstractCheckHandler)) {
            return null;
        }

        abstractCheckHandler.setConfig(config);
        // 递归处理
        abstractCheckHandler.setNextHandler(this.getHandler(config.getNext()));
        return abstractCheckHandler;
    }
}
