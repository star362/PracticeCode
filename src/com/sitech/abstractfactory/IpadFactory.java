package com.sitech.abstractfactory;

import com.sitech.abstractfactory.inter.AppleIpad;
import com.sitech.abstractfactory.inter.HuaWeiIpad;
import com.sitech.abstractfactory.inter.XiaoMiIpad;
import com.sitech.abstractfactory.inter.impl.Ipad;
import com.sitech.abstractfactory.inter.impl.PC;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: IpadFactory
 * @Description:
 * @date: 2019/9/20 14:55
 * @describe:
 */
public class IpadFactory extends AbstractFactory {
    @Override
    Ipad abstractGetIpad(String a) {
        if ("apple".equalsIgnoreCase(a)) {
            return new AppleIpad();
        } else if ("huawei".equalsIgnoreCase(a)) {
            return new HuaWeiIpad();
        } else if ("xiaomi".equalsIgnoreCase(a)) {
            return new XiaoMiIpad();
        }
        return null;
    }

    @Override
    PC abstractGetPC(String a) {
        return null;
    }
}
