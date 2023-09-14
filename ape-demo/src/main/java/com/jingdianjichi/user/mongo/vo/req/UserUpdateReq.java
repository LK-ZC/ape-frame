package com.jingdianjichi.user.mongo.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 测试数据 更新参数
 *
 * @author loser
 * @date 2023-06-13
 */
@Data
@ApiModel("测试数据 更新参数")
public class UserUpdateReq {

    @ApiModelProperty(value = "id", example = "ABC")
    private String id;

    @ApiModelProperty(value = "登录名称", example = "loserYa")
    private String loginName;

    @ApiModelProperty(value = "密码", example = "loserYa")
    private String passWord;

    @ApiModelProperty(value = "年龄", example = "19")
    private Integer age;

    @ApiModelProperty(value = "创建时间", example = "52555")
    private Long createTime;

    @ApiModelProperty(value = "修改时间", example = "889999")
    private Long updateTime;

}
