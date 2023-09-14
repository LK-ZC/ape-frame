package com.jingdianjichi.loser.biz;

import lombok.Data;

import java.util.Map;

@Data
public class Response {

    private Map<String, Object> headers;

    private String requestMethod;

}
