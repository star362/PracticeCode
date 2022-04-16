package com.sitech.abstractfactory.inter;

import com.sitech.abstractfactory.inter.impl.PC;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: ApplePc
 * @Description:
 * @date: 2019/9/20 14:45
 * @describe:
 */
public class ApplePc implements PC {
    @Override
    public void pcBrand() {
        System.out.println("苹果 pc");
    }
}
