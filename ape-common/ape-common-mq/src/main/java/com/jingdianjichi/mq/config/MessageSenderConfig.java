package com.jingdianjichi.mq.config;

import com.jingdianjichi.mq.service.QueueService;
import com.jingdianjichi.mq.service.impl.RabbitMQMessageSender;
import com.jingdianjichi.mq.service.impl.RocketMQMessageSender;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * 自动适配切换配置
 *
 * @author yx
 * @date 2023/07/26
 */
public class MessageSenderConfig {

    @Bean
    @ConditionalOnProperty(name = "spring.rocketmq.name-server")
    public QueueService rocketMQMessageSender(RocketMQTemplate rocketMQTemplate) {
        return new RocketMQMessageSender(rocketMQTemplate);
    }

    @Bean
    @ConditionalOnProperty(name = "spring.rabbitmq.host")
    public QueueService rabbitMQMessageSender(AmqpTemplate amqpTemplate) {
        return new RabbitMQMessageSender(amqpTemplate);
    }
}
