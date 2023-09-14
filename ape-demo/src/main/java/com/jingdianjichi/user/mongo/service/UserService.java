package com.jingdianjichi.user.mongo.service;


import com.jingdianjichi.user.mongo.entity.User;
import com.loser.core.sdk.EasyMongoService;

/**
 * 测试数据 接口
 *
 * @author loser
 * @date 2023-06-13
 */
public interface UserService extends EasyMongoService<String, User> {

}
