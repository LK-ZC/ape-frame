package com.jingdianjichi.user.designPattern.templatePattern.prod;

/**
 * @Author: ChickenWing
 * @Description: 规定模板使用
 * @DateTime: 2022/11/19 21:54
 */
public interface Action {

    /**
     * 参数校验，可以自定义异常抛出
     */
    void validate();

    /**
     * 执行
     */
    void execute();

    /**
     * 后续
     */
    void after();


}
