package com.jingdianjichi.user.mongo;

import com.loser.utils.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParamsUtil {

    /**
     * 参数非空校验
     */
    public static void checkNotNull(@Nullable Object params) {

        Class<?> clazz = params.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (ArrayUtils.isEmpty(fields)) {
            return;
        }
        for (Field field : fields) {
            field.setAccessible(true);
            Object result = null;
            try {
                result = field.get(params);
            } catch (Exception ignore) {
            }
            if (Objects.isNull(result)) {
                String msg = String.format("字段 %s 为空", field.getName());
                throw new RuntimeException(msg);
            }
        }

    }

    public static <T> List<T> mapList(List<?> list, Class<T> targetClass) {
        return list.stream().map(item -> copyProperties(item, targetClass)).collect(Collectors.toList());
    }

    /**
     * 对 BeanUtils 封装
     */
    public static <T> T copyProperties(@Nullable Object source, @Nullable Class<T> targetClass) {

        try {
            T result = targetClass.newInstance();
            BeanUtils.copyProperties(source, result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * 对 BeanUtils 封装
     */
    public static <T> T copyProperties(@Nullable Object source, @Nullable T result) {

        try {
            BeanUtils.copyProperties(source, result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
