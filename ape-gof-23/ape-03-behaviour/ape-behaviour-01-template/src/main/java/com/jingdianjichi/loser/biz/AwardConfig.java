package com.jingdianjichi.loser.biz;

import lombok.Data;

@Data
public class AwardConfig {

    private String awardId;

    private int awardNum;

    private int awardDay;

    private String bizId;

    /**
     * 奖励类型
     */
    private int type;

}
