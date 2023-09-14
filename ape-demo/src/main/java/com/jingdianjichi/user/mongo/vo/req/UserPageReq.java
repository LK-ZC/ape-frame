package com.jingdianjichi.user.mongo.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 测试数据 分页参数
 *
 * @author loser
 * @date 2023-06-13
 */
@Data
@ApiModel("测试数据 分页参数")
public class UserPageReq {

    @ApiModelProperty(value = "页码", required = true, example = "1")
    private Integer pageNo = 1;

    @ApiModelProperty(value = "页行数", required = true, example = "20")
    private Integer pageSize = 20;

    @ApiModelProperty(value = "id", example = "ABC")
    private String id;

    @ApiModelProperty(value = "登录名称", example = "loser")
    private String loginName;

    @ApiModelProperty(value = "密码", example = "loser")
    private String passWord;

    @ApiModelProperty(value = "年龄", example = "18")
    private Integer age;

    @ApiModelProperty(value = "开始时间", example = "1")
    private Long startTime;

    @ApiModelProperty(value = "结束时间", example = "10000000")
    private Long endTime;

}
