package com.jingdianjichi.eureka.config;

import com.jingdianjichi.interceptor.RestTemplateInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Stream.concat(
                Stream.of(new RestTemplateInterceptor()),
                restTemplate.getInterceptors().stream()
        ).collect(Collectors.toList()));
        return restTemplate;
    }

}
