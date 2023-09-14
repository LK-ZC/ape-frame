package com.jingdianjichi.mq.service.impl;

import com.jingdianjichi.mq.service.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;

/**
 * rabbitMq发送实现
 *
 * @author yx
 * @date 2023/07/26
 */
@RequiredArgsConstructor
public class RabbitMQMessageSender implements QueueService {

    private final AmqpTemplate amqpTemplate;

    @Override
    public void send(String topic, String message) {
        amqpTemplate.convertAndSend(topic, message);
    }
}
