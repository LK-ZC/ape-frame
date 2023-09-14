package com.jingdianjichi.loser.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Answer implements Cloneable {

    private String sort;

    private String answer;

    private boolean correct;

    @Override
    public Answer clone() {
        try {
            return (Answer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
