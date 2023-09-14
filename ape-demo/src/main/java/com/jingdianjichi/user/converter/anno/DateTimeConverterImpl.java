package com.jingdianjichi.user.converter.anno;

import com.jingdianjichi.tool.converter.base.BaseConverter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义时间转换器
 *
 * @author loser
 * @date 2023/07/22 10:40
 */
public class DateTimeConverterImpl extends BaseConverter<Long, String> {

    @Override
    protected String doConvert(Long value) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(value));
    }

}
