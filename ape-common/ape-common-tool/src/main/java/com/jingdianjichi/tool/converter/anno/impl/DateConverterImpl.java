package com.jingdianjichi.tool.converter.anno.impl;

import com.jingdianjichi.tool.converter.base.BaseConverter;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * 时间戳转日期
 *
 * @author loser
 * @date 2023/07/22 10:40
 */
public class DateConverterImpl extends BaseConverter<Long, String> {

    private SimpleDateFormat sdf;

    @Override
    protected String doConvert(Long value) {

        if (Objects.nonNull(sdf)) {
            return sdf.format(new Date(value));
        }
        String format = "yyyy-MM-dd";
        DateConverter annotation = property.getAnnotation(DateConverter.class);
        if (Objects.nonNull(annotation) && StringUtils.isNotEmpty(annotation.value())) {
            format = annotation.value();
        }
        this.sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(value));

    }

}
