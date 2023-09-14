package com.jingdianjichi.loser.biz.impl;

import com.jingdianjichi.loser.biz.Command;
import com.jingdianjichi.loser.biz.CommandInvoker;
import com.jingdianjichi.loser.core.Autowired;
import com.jingdianjichi.loser.core.Component;
import lombok.Data;

@Data
@Component
public class ConcreteCommand implements Command {

    private final String desc = "测试命令";

    @Autowired
    private CommandInvoker commandInvoker;

    @Override
    public void execute() {
        commandInvoker.execute(this);
    }

}
