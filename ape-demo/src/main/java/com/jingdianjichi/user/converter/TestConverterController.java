package com.jingdianjichi.user.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestConverterController {

    @GetMapping("/loser")
    public Loser loser() {
        Loser loser = new Loser();
        loser.setId(System.currentTimeMillis());
        loser.setName("鸡翅呀");
        loser.setHeadUrl("http://img.xxx.com/user/head_0001.png");
        loser.setPhone("13800138000");
        loser.setIdCard("440923199712052555");
        loser.setTime(System.currentTimeMillis());
        loser.setTime2(System.currentTimeMillis());
        loser.setTime3(System.currentTimeMillis());
        loser.setReqTime(System.currentTimeMillis());
        loser.setStatus(1);
        return loser;
    }

}
