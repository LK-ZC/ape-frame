package com.jingdianjichi.home.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("ape-cloud-sku")
public interface SkuFeignService {

    @GetMapping("/test")
    public String test();

    @GetMapping("/testTimeout")
    public String testTimeout();


}
