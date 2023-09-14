package com.jingdianjichi.loser.biz.impl;

import com.jingdianjichi.loser.biz.Task;
import com.jingdianjichi.loser.biz.TaskState;

public class FinishState implements TaskState {

    @Override
    public void create(Task task) {
        System.err.println("任务已经开始 不能创建" + task);
    }

    @Override
    public void start(Task task) {
        System.err.println("任务已经开始 不能重复开始" + task);
    }

    @Override
    public void finish(Task task) {
        System.out.println("完成任务" + task);
        task.setState(new OverState());
    }

}
