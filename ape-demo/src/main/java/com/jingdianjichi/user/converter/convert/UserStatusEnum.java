package com.jingdianjichi.user.converter.convert;

public enum UserStatusEnum {

    S_LOCK(1, "锁定"),
    S_UN_LOCK(2, "正常"),
    ;

    public final int status;
    public final String desc;

    UserStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

}
