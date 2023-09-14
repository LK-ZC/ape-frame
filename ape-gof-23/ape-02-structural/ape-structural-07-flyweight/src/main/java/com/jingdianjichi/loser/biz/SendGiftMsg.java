package com.jingdianjichi.loser.biz;

import lombok.Data;

@Data
public class SendGiftMsg {

    private Long userId;

    private Long anchorId;

    private Long giftId;

    private Long sendGiftTime;

}
