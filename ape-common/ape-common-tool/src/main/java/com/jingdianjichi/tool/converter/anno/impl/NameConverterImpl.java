package com.jingdianjichi.tool.converter.anno.impl;

import com.jingdianjichi.tool.converter.base.BaseConverter;

/**
 * 名称隐藏第2位
 *
 * @author loser
 * @date 2023/07/22 10:40
 */
public class NameConverterImpl extends BaseConverter<String, String> {

    @Override
    protected String doConvert(String value) {
        return value.replaceAll("(\\S)\\S(\\S*)", "$1*$2");
    }

}
