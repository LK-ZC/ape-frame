package com.jingdianjichi.user.converter;

import com.jingdianjichi.tool.converter.anno.CustomConverter;
import com.jingdianjichi.tool.converter.anno.impl.DateConverter;
import com.jingdianjichi.tool.converter.anno.impl.IdCardConverter;
import com.jingdianjichi.tool.converter.anno.impl.NameConverter;
import com.jingdianjichi.tool.converter.anno.impl.NumberConverter;
import com.jingdianjichi.tool.converter.anno.impl.PhoneConverter;
import com.jingdianjichi.user.converter.anno.DateTimeConverter;
import com.jingdianjichi.user.converter.convert.ImageZipUrlConverter;
import com.jingdianjichi.user.converter.convert.UserStatusDescConverter;
import lombok.Data;

@Data
public class Loser {

    private Long id;

    @PhoneConverter
    private String phone;

    @IdCardConverter
    private String idCard;

    @DateConverter("yyyy-MM-dd HH:mm:ss")
    private Long time;

    @DateConverter("HH:mm:ss")
    private Long time2;

    @DateConverter
    private Long time3;

    @NumberConverter
    private Double num = 1.456D;

    @NumberConverter("##000.000 kg")
    private Double num1 = 1.456D;

    @NumberConverter("##.##")
    private Float num2 = 1.456F;

    /**
     * 方式一：使用默认提供注解
     */
    @NameConverter
    private String name;

    /**
     * 方式二：自定义注解
     */
    @DateTimeConverter
    private Long reqTime;

    /**
     * 方式三：指定转换器类
     */
    @CustomConverter(UserStatusDescConverter.class)
    private Integer status;

    @CustomConverter(ImageZipUrlConverter.class)
    private String headUrl;

}
