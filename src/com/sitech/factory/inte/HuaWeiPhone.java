package com.sitech.factory.inte;

import com.sitech.factory.inte.impl.Phone;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: HuaWeiPhone
 * @Description:
 * @date 2019/9/20 14:03
 * @描述
 */
public class HuaWeiPhone implements Phone {
    @Override
    public void use() {
        System.out.println("使用华为手机");
    }
}
