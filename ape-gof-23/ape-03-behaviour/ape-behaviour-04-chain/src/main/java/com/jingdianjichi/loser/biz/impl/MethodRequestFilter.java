package com.jingdianjichi.loser.biz.impl;

import com.jingdianjichi.loser.biz.Request;
import com.jingdianjichi.loser.biz.RequestFilter;
import com.jingdianjichi.loser.biz.RequestFilterChain;
import com.jingdianjichi.loser.biz.Response;
import com.jingdianjichi.loser.core.Component;

@Component
public class MethodRequestFilter implements RequestFilter {

    @Override
    public void doFilter(Request request, Response response, RequestFilterChain filterChain) {

        System.out.println("MethodRequestFilter index " + sort() + " " + request);
        if ("POST".equals(request.getRequestMethod())) {
            filterChain.doFilter(request, response);
        } else {
            throw new RuntimeException("不支持方法类型");
        }

    }

}
