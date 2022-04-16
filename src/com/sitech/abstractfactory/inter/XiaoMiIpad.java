package com.sitech.abstractfactory.inter;

import com.sitech.abstractfactory.inter.impl.Ipad;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: XiaoMiIpad
 * @Description:
 * @date: 2019/9/20 14:42
 * @describe:
 */
public class XiaoMiIpad implements Ipad {
    @Override
    public void ipadBrand() {
        System.out.println("小米 ipad");
    }
}
