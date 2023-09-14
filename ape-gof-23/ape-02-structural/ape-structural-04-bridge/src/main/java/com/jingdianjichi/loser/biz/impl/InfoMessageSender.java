package com.jingdianjichi.loser.biz.impl;

import com.jingdianjichi.loser.biz.AbstractMessage;
import com.jingdianjichi.loser.biz.Imessage;
import com.jingdianjichi.loser.biz.Message;

public class InfoMessageSender extends AbstractMessage {

    public InfoMessageSender(Imessage imessage) {
        super(imessage);
    }

    @Override
    public void send(Message message, String target) {
        System.out.println("普通提示消息");
        super.send(message, target);
    }

}
