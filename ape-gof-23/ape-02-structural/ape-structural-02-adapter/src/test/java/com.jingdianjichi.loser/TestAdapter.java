package com.jingdianjichi.loser;

import com.jingdianjichi.loser.biz.adapter.TaskHandler;
import com.jingdianjichi.loser.biz.mq.LoginMsg;
import com.jingdianjichi.loser.biz.mq.OnlineMsg;
import com.jingdianjichi.loser.core.ApplicationContext;
import com.jingdianjichi.loser.core.ContextUtils;
import org.junit.Test;

import java.util.Date;

/**
 * 推荐指数：★★★★☆
 * <p>
 * 适配器是一种结构型设计模式，它能使接口不兼容的对象能够相互合作。
 * <p>
 * 模拟mq接受到不同下消息适配成统一任务上下文消息
 */
public class TestAdapter {

    @Test
    public void test() {

        // 模拟活动消息 适配成 任务上下文消息
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.start();
        ContextUtils.setApplicationContext(applicationContext);

        int actId = 1024;
        TaskHandler taskHandler = ContextUtils.getBean(TaskHandler.class);
        LoginMsg loginMsg = new LoginMsg();
        loginMsg.setUid(100L);
        loginMsg.setLoginTime(new Date());
        loginMsg.setLogin(false);
        taskHandler.doTask(actId, loginMsg);

        OnlineMsg onlineMsg = new OnlineMsg();
        onlineMsg.setUserId(110L);
        onlineMsg.setOnlineTime(0L);
        taskHandler.doTask(actId, onlineMsg);

    }

}
