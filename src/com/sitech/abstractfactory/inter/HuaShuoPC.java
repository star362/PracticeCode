package com.sitech.abstractfactory.inter;

import com.sitech.abstractfactory.inter.impl.PC;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: HuaShuoPC
 * @Description:
 * @date: 2019/9/20 14:45
 * @describe:
 */
public class HuaShuoPC implements PC {
    @Override
    public void pcBrand() {
        System.out.println("华硕 pc");
    }
}
