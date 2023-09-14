package com.jingdianjichi.loser.core;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Paper implements Cloneable {

    private String student;

    private List<Question> questions;

    @Override
    public Paper clone() {
        try {
            Paper paper = (Paper) super.clone();
            paper.setQuestions(questions.stream().map(Question::clone).collect(Collectors.toList()));
            return paper;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


}
