package com.jingdianjichi.loser.biz.adapter;

import cn.hutool.core.util.ObjectUtil;
import com.jingdianjichi.loser.core.Component;
import com.jingdianjichi.loser.core.ContextUtils;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Component
@SuppressWarnings("all")
public class TaskHandler {

    private <T> TaskContextAdapter<T> getAdapter(T msg) {
        List<TaskContextAdapter> beans = ContextUtils.getBeans(TaskContextAdapter.class);
        String mqMessageClassName = msg.getClass().getName();
        for (TaskContextAdapter bean : beans) {
            if (getTName(bean).equals(mqMessageClassName)) {
                return bean;
            }
        }
        throw new RuntimeException("bean error");
    }

    public <T> void doTask(int actId, T msg) {

        TaskContext taskContext = getAdapter(msg).adapter(actId, msg);
        System.out.println(taskContext);

    }

    private String getTName(TaskContextAdapter converter) {

        if (ObjectUtil.isNull(converter)) {
            return null;
        }
        Type[] supperClass = converter.getClass().getGenericInterfaces();
        for (Type aClass : supperClass) {
            if (aClass instanceof ParameterizedTypeImpl) {
                if (((ParameterizedTypeImpl) aClass).getRawType() != TaskContextAdapter.class) {
                    continue;
                }
                Type subType = ((ParameterizedType) aClass).getActualTypeArguments()[0];
                return ((Class<?>) subType).getName();
            }
        }
        return null;

    }

}
