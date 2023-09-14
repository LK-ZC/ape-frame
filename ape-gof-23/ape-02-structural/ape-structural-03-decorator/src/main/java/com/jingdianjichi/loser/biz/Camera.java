package com.jingdianjichi.loser.biz;

import com.jingdianjichi.loser.core.Car;
import com.jingdianjichi.loser.core.Goods;

import java.util.List;

public class Camera extends Goods {

    public Camera(Car car) {
        super(car);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 500;
    }

    @Override
    public List<String> getNames() {
        List<String> names = super.getNames();
        names.add("行车记录仪");
        return names;
    }
}
