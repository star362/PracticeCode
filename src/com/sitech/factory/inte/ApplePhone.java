package com.sitech.factory.inte;

import com.sitech.factory.inte.impl.Phone;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: ApplePhone
 * @Description:
 * @date 2019/9/20 14:04
 * @描述
 */
public class ApplePhone implements Phone {
    @Override
    public void use() {
        System.out.println("使用苹果手机");
    }

    @Override
    public String aa() {
        return "bb";
    }
}
