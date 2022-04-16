package com.sitech.abstractfactory;

import com.sitech.abstractfactory.inter.ApplePc;
import com.sitech.abstractfactory.inter.HuaShuoPC;
import com.sitech.abstractfactory.inter.impl.Ipad;
import com.sitech.abstractfactory.inter.impl.PC;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: PcFactory
 * @Description:
 * @date: 2019/9/20 14:55
 * @describe:
 */
public class PcFactory extends AbstractFactory {
    @Override
    Ipad abstractGetIpad(String a) {
        return null;
    }

    @Override
    PC abstractGetPC(String a) {
        if("apple".equalsIgnoreCase(a)){
            return new ApplePc();
        }else if("huashuo".equalsIgnoreCase(a)){
            return new HuaShuoPC();
        }

        return null;
    }
}
