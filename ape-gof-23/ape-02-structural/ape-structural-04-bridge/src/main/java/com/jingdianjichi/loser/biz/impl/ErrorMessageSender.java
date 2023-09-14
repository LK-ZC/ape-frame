package com.jingdianjichi.loser.biz.impl;

import com.jingdianjichi.loser.biz.AbstractMessage;
import com.jingdianjichi.loser.biz.Imessage;
import com.jingdianjichi.loser.biz.Message;

public class ErrorMessageSender extends AbstractMessage {

    public ErrorMessageSender(Imessage imessage) {
        super(imessage);
    }

    @Override
    public void send(Message message, String target) {
        System.out.println("紧急错误消息");
        super.send(message, target);
    }

}
