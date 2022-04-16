package com.sitech.abstractfactory;

import com.sitech.abstractfactory.inter.impl.Ipad;
import com.sitech.abstractfactory.inter.impl.PC;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: AbstractFactory
 * @Description:
 * @date: 2019/9/20 14:50
 * @describe:
 */
public abstract class AbstractFactory {
    abstract Ipad abstractGetIpad(String a);
    abstract PC abstractGetPC(String a);
}
