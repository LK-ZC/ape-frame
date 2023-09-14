package com.jingdianjichi.loser.biz;

public interface TaskFilter<T> {

    boolean doFilter(T t);

}
