package com.jingdianjichi.loser.biz;

import lombok.Data;

import java.util.Map;

@Data
public class Request {

    private Map<String, Object> headers;

    private String requestMethod;

}
