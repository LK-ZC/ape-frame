package com.jingdianjichi.user.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * 测试数据
 *
 * @author loser
 * @date 2023-06-13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String loginName;

    private String passWord;

    private Integer age;

    private Long createTime;

    private Long updateTime;

}
