package com.jingdianjichi.loser.biz;

public abstract class AbstractMessage {

    protected Imessage imessage;

    public AbstractMessage(Imessage imessage) {
        this.imessage = imessage;
    }

    public void send(Message message, String target) {
        imessage.send(message, target);
    }

}
