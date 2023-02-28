package com.pattern.handler;

import com.pattern.User;


public class LoginHandler extends Handler{
    @Override
    public void doHandler(User member) {
        if (!"jack".equals(member.getName()) || !"666".equals(member.getPassword())) {
            System.out.println("用户名密码不正确");
            return;
        }
        if (null != next) {
            next.doHandler(member);
        }
    }
}
