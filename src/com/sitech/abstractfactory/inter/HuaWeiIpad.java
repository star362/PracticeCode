package com.sitech.abstractfactory.inter;

import com.sitech.abstractfactory.inter.impl.Ipad;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: HuaWeiIpad
 * @Description:
 * @date: 2019/9/20 14:42
 * @describe:
 */
public class HuaWeiIpad implements Ipad {
    @Override
    public void ipadBrand() {
        System.out.println("华为 ipad");
    }
}
