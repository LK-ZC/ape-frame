package com.jingdianjichi.loser.core.imp;

import com.jingdianjichi.loser.core.Game;
import com.jingdianjichi.loser.core.IVisitor;

public class VipGame extends Game {

    public int getmVipPrice() {
        return mVipPrice;
    }

    public void setmVipPrice(int mVipPrice) {
        this.mVipPrice = mVipPrice;
    }

    private int mVipPrice;

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

}
