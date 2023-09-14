package com.jingdianjichi.loser.biz.adapter.impl;

import com.jingdianjichi.loser.biz.adapter.TaskContext;
import com.jingdianjichi.loser.biz.adapter.TaskContextAdapter;
import com.jingdianjichi.loser.biz.mq.OnlineMsg;
import com.jingdianjichi.loser.core.Component;

@Component
public class OnlineMsgAdapter implements TaskContextAdapter<OnlineMsg> {

    @Override
    public TaskContext adapter(int actId, OnlineMsg msg) {
        TaskContext taskContext = new TaskContext();
        taskContext.setActId(actId);
        taskContext.setUserId(msg.getUserId());
        taskContext.setTime(msg.getOnlineTime());
        taskContext.setNum(1);
        taskContext.setType(2);
        return taskContext;
    }

}
