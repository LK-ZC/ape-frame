package com.jingdianjichi.loser.biz;

import cn.hutool.core.util.ObjectUtil;
import com.jingdianjichi.loser.core.Component;
import com.jingdianjichi.loser.core.ContextUtils;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TaskFilterFactory {

    private static boolean init = false;
    private static final Map<Class<?>, TaskFilter> taskFilterMap = new ConcurrentHashMap<>();

    public static <T> TaskFilter<T> getFilter(Class<T> target) {

        if (!init) {
            synchronized (TaskFilterFactory.class) {
                if (!init) {
                    System.out.println("init start");
                    List<TaskFilter> beans = ContextUtils.getBeans(TaskFilter.class);
                    for (TaskFilter bean : beans) {
                        Class<?> tType = getTType(bean);
                        taskFilterMap.put(tType, bean);
                    }
                    init = true;
                    System.out.println("init end");
                }
            }
        }
        return taskFilterMap.get(target);

    }

    private static Class<?> getTType(TaskFilter<?> taskFilter) {

        if (ObjectUtil.isNull(taskFilter)) {
            return null;
        }
        Type[] supperClass = taskFilter.getClass().getGenericInterfaces();
        for (Type aClass : supperClass) {
            if (aClass instanceof ParameterizedTypeImpl) {
                if (((ParameterizedTypeImpl) aClass).getRawType() != TaskFilter.class) {
                    continue;
                }
                Type subType = ((ParameterizedType) aClass).getActualTypeArguments()[0];
                return (Class<?>) subType;
            }
        }
        return null;

    }


}
