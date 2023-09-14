package com.jingdianjichi.loser.core.imp;

import com.jingdianjichi.loser.core.Game;
import com.jingdianjichi.loser.core.IVisitor;

public class FreeGame extends Game {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
