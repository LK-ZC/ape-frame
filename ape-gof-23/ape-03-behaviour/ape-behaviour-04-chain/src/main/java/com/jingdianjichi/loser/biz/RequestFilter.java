package com.jingdianjichi.loser.biz;

public interface RequestFilter {

    void doFilter(Request request, Response response, RequestFilterChain filterChain);

    default int sort() {
        return 1;
    }

}
