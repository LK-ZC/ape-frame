package com.jingdianjichi.loser.biz.impl.msg;

import com.jingdianjichi.loser.biz.Imessage;
import com.jingdianjichi.loser.biz.Message;

public class WxMessage implements Imessage {

    @Override
    public void send(Message message, String target) {
        System.out.println("发送消息到企业微信群");
        System.out.println();
    }

}
