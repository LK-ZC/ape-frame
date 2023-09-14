package com.jingdianjichi.loser.biz.impl;

import com.jingdianjichi.loser.biz.Task;
import com.jingdianjichi.loser.biz.TaskState;

public class OverState implements TaskState {

    @Override
    public void create(Task task) {
        System.err.println("任务已经完成 不能操作" + task);
    }

    @Override
    public void start(Task task) {
        System.err.println("任务已经完成 不能操作" + task);
    }

    @Override
    public void finish(Task task) {
        System.err.println("任务已经完成 不能操作" + task);
    }

}
