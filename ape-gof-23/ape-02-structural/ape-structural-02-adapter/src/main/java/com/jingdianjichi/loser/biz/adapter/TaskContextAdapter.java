package com.jingdianjichi.loser.biz.adapter;

public interface TaskContextAdapter<T> {

    TaskContext adapter(int actId, T msg);

}
