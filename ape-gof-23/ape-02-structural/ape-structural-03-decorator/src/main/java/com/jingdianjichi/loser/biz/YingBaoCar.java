package com.jingdianjichi.loser.biz;

import com.jingdianjichi.loser.core.Car;

import java.util.ArrayList;
import java.util.List;

public class YingBaoCar implements Car {

    @Override
    public int getPrice() {
        return 150000;
    }

    @Override
    public List<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        names.add("影豹");
        return names;
    }

}
