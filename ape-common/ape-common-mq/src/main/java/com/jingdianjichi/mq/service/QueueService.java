package com.jingdianjichi.mq.service;

/**
 * 队列服务:消息发送接口
 *
 * @author yx
 * @date 2023/07/26
 */
public interface QueueService {

    /**
     * 发送
     *
     * @param topic   主题
     * @param message 消息
     */
    void send(String topic, String message);
}
