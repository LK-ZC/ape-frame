package com.jingdianjichi.user.mongo.controller;

import com.jingdianjichi.bean.Result;
import com.jingdianjichi.swagger.config.ApiVersion;
import com.jingdianjichi.user.mongo.entity.User;
import com.jingdianjichi.user.mongo.handler.UserHandler;
import com.jingdianjichi.user.mongo.vo.req.UserPageReq;
import com.jingdianjichi.user.mongo.vo.req.UserSaveReq;
import com.jingdianjichi.user.mongo.vo.req.UserUpdateReq;
import com.jingdianjichi.user.mongo.vo.resp.UserInfoResp;
import com.loser.core.entity.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试数据 接口
 *
 * @author loser
 * @date 2023-06-13
 */
@RestController
@RequestMapping("user")
@Api("测试数据 接口")
@ApiVersion("user")
public class UserController {

    @Autowired
    private UserHandler userHandler;

    @ApiOperation(value = "01-新增测试数据")
    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody UserSaveReq req) {
        return userHandler.save(req);
    }

    @ApiOperation(value = "02-修改测试数据")
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody UserUpdateReq req) {
        return userHandler.update(req);
    }

    @ApiOperation(value = "03-删除测试数据")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteById(@ApiParam(value = "id") @PathVariable String id) {
        return userHandler.deleteById(id);
    }

    @ApiOperation(value = "04-通过ID查询测试数据")
    @GetMapping("/get/{id}")
    public Result<UserInfoResp> getById(@ApiParam(value = "id") @PathVariable String id) {
        return userHandler.getById(id);
    }

    @ApiOperation(value = "05-分页查询测试数据")
    @PostMapping("/page")
    public Result<Page<User>> queryList(@RequestBody UserPageReq req) {
        return userHandler.queryList(req);
    }

}
