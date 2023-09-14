package com.jingdianjichi.user.mongo.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 测试数据 保存参数
 *
 * @author loser
 * @date 2023-06-13
 */
@Data
@ApiModel("测试数据 保存参数")
public class UserSaveReq {

    @ApiModelProperty(value = "id", example = "ABC")
    private String id;

    @ApiModelProperty(value = "登录名称", example = "loser")
    private String loginName;

    @ApiModelProperty(value = "密码", example = "loser")
    private String passWord;

    @ApiModelProperty(value = "年龄", example = "18")
    private Integer age;

    @ApiModelProperty(value = "创建时间", example = "1000")
    private Long createTime;

    @ApiModelProperty(value = "修改时间", example = "2000")
    private Long updateTime;

}
