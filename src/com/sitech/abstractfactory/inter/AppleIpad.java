package com.sitech.abstractfactory.inter;

import com.sitech.abstractfactory.inter.impl.Ipad;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: AppleIpad
 * @Description:
 * @date: 2019/9/20 14:43
 * @describe:
 */
public class AppleIpad implements Ipad {
    @Override
    public void ipadBrand() {
        System.out.println("苹果 Ipad");
    }
}
