package com.jingdianjichi.loser.biz;

import com.jingdianjichi.loser.core.Param;
import com.jingdianjichi.loser.core.Select;

public interface SysUserDao {

    @Select("select * from sys_user where id = #{id}")
    SysUser getById(@Param("id") Long id);

}
