package com.sitech.factory.inte.impl;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: Phone
 * @Description:
 * @date 2019/9/20 13:58
 * @描述
 */
@FunctionalInterface
public interface Phone {
    void use();
    default  String aa(){
        return "aa";
    }
}
