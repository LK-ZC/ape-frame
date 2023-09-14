package com.jingdianjichi.user.mongo.handler;

import com.jingdianjichi.bean.Result;
import com.jingdianjichi.user.mongo.ParamsUtil;
import com.jingdianjichi.user.mongo.entity.User;
import com.jingdianjichi.user.mongo.service.UserService;
import com.jingdianjichi.user.mongo.vo.req.UserPageReq;
import com.jingdianjichi.user.mongo.vo.req.UserSaveReq;
import com.jingdianjichi.user.mongo.vo.req.UserUpdateReq;
import com.jingdianjichi.user.mongo.vo.resp.UserInfoResp;
import com.loser.core.entity.Page;
import com.loser.core.wrapper.LambdaQueryWrapper;
import com.loser.core.wrapper.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 测试数据 处理器
 *
 * @author loser
 * @date 2023-06-13
 */
@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    /**
     * 新增测试数据
     */
    public Result<Boolean> save(UserSaveReq req) {

        User save = ParamsUtil.copyProperties(req, User.class);
        return Result.ok(userService.save(save));

    }

    /**
     * 修改测试数据
     */
    public Result<Boolean> update(UserUpdateReq req) {

        User update = ParamsUtil.copyProperties(req, User.class);
        return Result.ok(userService.updateById(update));

    }

    /**
     * 通过id删除测试数据
     */
    public Result<Boolean> deleteById(String id) {

        return Result.ok(userService.removeById(id));

    }

    /**
     * 通过id获取测试数据
     */
    public Result<UserInfoResp> getById(String id) {

        User dbData = userService.getById(id);
        if (Objects.isNull(dbData)) {
            return Result.ok();
        }
        return Result.ok(ParamsUtil.copyProperties(dbData, UserInfoResp.class));

    }

    /**
     * 分页获取测试数据
     */
    public Result<Page<User>> queryList(UserPageReq req) {

        LambdaQueryWrapper<User> query = Wrappers.<User>lambdaQuery()
                .eq(Objects.nonNull(req.getAge()), User::getAge, req.getAge())
                .eq(Objects.nonNull(req.getLoginName()), User::getLoginName, req.getLoginName())
                .eq(Objects.nonNull(req.getPassWord()), User::getPassWord, req.getPassWord())
                .eq(Objects.nonNull(req.getAge()), User::getAge, req.getAge())
                .between((Objects.nonNull(req.getStartTime()) && Objects.nonNull(req.getEndTime())), User::getCreateTime, req.getStartTime(), req.getEndTime());
        Page<User> page = userService.page(query, req.getPageNo(), req.getPageSize());
        return Result.ok(page);

    }

}
