package com.pattern.handler;

import com.pattern.User;

import java.lang.reflect.Member;

public class BusinessLogicHandler extends Handler {
    @Override
    public void doHandler(User member) {
        System.out.println("执行业务逻辑。。");

    }
}
