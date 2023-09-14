package com.jingdianjichi.user.converter.convert;


import com.jingdianjichi.tool.converter.base.BaseConverter;

/**
 * 图片压缩参数拼接转换器
 *
 * @author loser
 * @date 2023/07/22 10:40
 */
public class ImageZipUrlConverter extends BaseConverter<String, String> {

    @Override
    protected String doConvert(String value) {
        return value + "!q80";
    }

}
