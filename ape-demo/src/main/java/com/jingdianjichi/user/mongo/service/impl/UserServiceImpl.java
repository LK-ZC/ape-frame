package com.jingdianjichi.user.mongo.service.impl;

import com.jingdianjichi.user.mongo.entity.User;
import com.jingdianjichi.user.mongo.service.UserService;
import com.loser.core.impl.EasyMongoServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 测试数据 实现类
 *
 * @author loser
 * @date 2023-06-13
 */
@Service
public class UserServiceImpl extends EasyMongoServiceImpl<String, User> implements UserService {

}
