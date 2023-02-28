package com.pattern;

import com.pattern.handler.*;


/**
 * 责任链设计模式
 */
public class ZRLDemo {


    public static void main(String[] args) {
        Handler.Builder builder = new Handler.Builder();
        //这里就是链式编程，谁在前谁在后看的清清楚楚，明明白白
        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler())
                .addHandler(new BusinessLogicHandler());
        User member = new User();
        member.setName("jack");
        member.setPassword("666");
        member.setRoleName("管理员");
        builder.build().doHandler(member);
    }




}
