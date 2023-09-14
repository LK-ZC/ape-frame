package com.jingdianjichi.mq.service.impl;

import com.jingdianjichi.mq.service.QueueService;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * rocketMq发送实现
 *
 * @author yx
 * @date 2023/07/26
 */
@RequiredArgsConstructor
public class RocketMQMessageSender implements QueueService {

    private final RocketMQTemplate rocketMQTemplate;

    @Override
    public void send(String topic, String message) {
        rocketMQTemplate.convertAndSend(topic, message);
    }
}
