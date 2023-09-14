package com.jingdianjichi.tool.converter.anno.impl;

import com.jingdianjichi.tool.converter.base.BaseConverter;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * 数字格式化
 *
 * @author loser
 * @date 2023/07/22 10:40
 */
public class NumberConverterImpl extends BaseConverter<Number, String> {

    private DecimalFormat df;

    @Override
    protected String doConvert(Number value) {

        if (Objects.nonNull(df)) {
            return df.format(value);
        }
        NumberConverter annotation = property.getAnnotation(NumberConverter.class);
        df = new DecimalFormat();
        if (Objects.nonNull(annotation) && StringUtils.isNotEmpty(annotation.value())) {
            df.applyPattern(annotation.value());
        }
        return df.format(value);

    }

}
