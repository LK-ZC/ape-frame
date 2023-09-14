package com.jingdianjichi.user.delayQueue;

import com.alibaba.fastjson.JSON;
import com.jingdianjichi.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: ChickenWing
 * @Description: 群发任务延时service
 * @DateTime: 2023/1/8 23:24
 */
@Service
@Slf4j
public class MassMailTaskService {

    @Resource
    private RedisUtil redisUtil;

    private static final String MASS_MAIL_TASK_KEY = "massMailTask";

    public void pushMassMailTaskQueue(MassMailTask massMailTask) {
        Date startTime = massMailTask.getStartTime();
        if (startTime == null) {
            return;
        }
        if (startTime.compareTo(new Date()) <= 0) {
            return;
        }
        log.info("定时群发任务加入延时队列，massMailTask:{}", JSON.toJSON(massMailTask));
        redisUtil.zAdd(MASS_MAIL_TASK_KEY, massMailTask.getTaskId().toString(), startTime.getTime());
    }

    public Set<Long> poolMassMailTaskQueue() {
        Set<String> taskIdSet = redisUtil.rangeByScore(MASS_MAIL_TASK_KEY, 0, System.currentTimeMillis());
        log.info("获取延迟群发任务，taskIdSet：{}", JSON.toJSON(taskIdSet));
        if (CollectionUtils.isEmpty(taskIdSet)) {
            return Collections.emptySet();
        }
        redisUtil.removeZsetList(MASS_MAIL_TASK_KEY, taskIdSet);
        return taskIdSet.stream().map(n -> Long.parseLong(n)).collect(Collectors.toSet());
    }


}
