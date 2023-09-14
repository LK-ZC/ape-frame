package com.jingdianjichi.loser.biz.impl;

import com.jingdianjichi.loser.biz.Task;
import com.jingdianjichi.loser.biz.TaskState;

public class CreateState implements TaskState {

    @Override
    public void create(Task task) {
        System.out.println("任务创建" + task);
        task.setState(new StartState());
    }

    @Override
    public void start(Task task) {
        System.err.println("任务未创建 不能开始" + task);
    }

    @Override
    public void finish(Task task) {
        System.err.println("任务未创建 不能完成" + task);
    }

}
