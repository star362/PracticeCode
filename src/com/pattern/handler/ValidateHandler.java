package com.pattern.handler;

import com.pattern.User;

public class ValidateHandler extends Handler {
    @Override
    public void doHandler(User member) {
        if (member.getName() == null || member.getPassword() == null) {
            System.out.println("用户名和密码不能为空");
            return;
        }
        if (null != next) {
            next.doHandler(member);
        }
    }
}
