package com.jingdianjichi.loser.biz.impl.msg;

import com.jingdianjichi.loser.biz.Imessage;
import com.jingdianjichi.loser.biz.Message;

public class SmsMessage implements Imessage {

    @Override
    public void send(Message message, String target) {
        System.out.println("发送消息到指定用户手机");
        System.out.println();
    }

}
