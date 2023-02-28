package com.pattern.handler;

import com.pattern.User;

import java.lang.reflect.Member;

public class AuthHandler extends Handler{
    @Override
    public void doHandler(User member) {
        if (!"管理员".equals(member.getRoleName())) {
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        if (null != next) {
            next.doHandler(member);
        }
    }
}
