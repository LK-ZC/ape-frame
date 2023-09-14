package com.jingdianjichi.user.converter.convert;


import com.jingdianjichi.tool.converter.base.BaseConverter;

/**
 * 用户状态枚举转换器
 *
 * @author loser
 * @date 2023/07/22 10:40
 */
public class UserStatusDescConverter extends BaseConverter<Integer, String> {

    @Override
    protected String doConvert(Integer value) {
        for (UserStatusEnum statusEnum : UserStatusEnum.values()) {
            if (statusEnum.status == value) {
                return statusEnum.desc;
            }
        }
        return "未知";
    }

}
