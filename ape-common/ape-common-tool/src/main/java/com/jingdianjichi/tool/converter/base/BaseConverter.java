package com.jingdianjichi.tool.converter.base;

import com.fasterxml.jackson.databind.BeanProperty;

/**
 * 基础数据转换器
 *
 * @author loser
 * @date 2023/07/22 10:40
 */
public abstract class BaseConverter<T, D> {

    /**
     * 透传自定义注解信息
     */
    protected BeanProperty property;

    /**
     * 将数据进行转换
     *
     * @param value 源数据
     * @return 目标数据
     */
    protected abstract D doConvert(T value);

}
