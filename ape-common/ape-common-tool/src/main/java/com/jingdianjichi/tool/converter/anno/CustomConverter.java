package com.jingdianjichi.tool.converter.anno;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jingdianjichi.tool.converter.base.BaseConverter;
import com.jingdianjichi.tool.converter.base.DefaultConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义数据转换器
 *
 * @author loser
 * @date 2023/07/22 10:40
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@JacksonAnnotationsInside
@JsonSerialize(using = DefaultConverter.class)
public @interface CustomConverter {

    Class<? extends BaseConverter> value();

}
