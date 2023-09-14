package com.jingdianjichi.loser.biz.impl;

import com.jingdianjichi.loser.biz.SendGiftMsg;
import com.jingdianjichi.loser.biz.TaskFilter;
import com.jingdianjichi.loser.core.Component;

import java.util.Objects;

@Component
public class SendGiftTaskFilter implements TaskFilter<SendGiftMsg> {

    @Override
    public boolean doFilter(SendGiftMsg sendGiftMsg) {
        return Objects.isNull(sendGiftMsg) || Objects.isNull(sendGiftMsg.getUserId()) || Objects.isNull(sendGiftMsg.getGiftId());
    }

}
