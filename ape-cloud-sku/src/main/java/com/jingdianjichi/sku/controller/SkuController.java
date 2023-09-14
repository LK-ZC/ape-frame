package com.jingdianjichi.sku.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SkuController {

    @GetMapping("/test")
    public String test() {
        return "Hello Sku World";
    }


    @GetMapping("/testTimeout")
    public String testTimeout() throws InterruptedException {
        Thread.sleep(3000);
        return "Hello Sku World timeOut!";
    }

}
