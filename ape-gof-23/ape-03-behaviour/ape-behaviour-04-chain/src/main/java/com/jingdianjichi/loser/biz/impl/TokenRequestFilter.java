package com.jingdianjichi.loser.biz.impl;

import com.jingdianjichi.loser.biz.Request;
import com.jingdianjichi.loser.biz.RequestFilter;
import com.jingdianjichi.loser.biz.RequestFilterChain;
import com.jingdianjichi.loser.biz.Response;
import com.jingdianjichi.loser.core.Component;

import java.util.Objects;

@Component
public class TokenRequestFilter implements RequestFilter {

    @Override
    public void doFilter(Request request, Response response, RequestFilterChain filterChain) {

        System.out.println("TokenRequestFilter index " + sort() + " " + request);
        if (Objects.nonNull(request.getHeaders().get("token"))) {
            filterChain.doFilter(request, response);
        } else {
            throw new RuntimeException("token 为空");
        }

    }

    @Override
    public int sort() {
        return 3;
    }
}
