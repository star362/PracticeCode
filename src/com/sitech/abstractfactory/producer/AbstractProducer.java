package com.sitech.abstractfactory.producer;

import com.sitech.abstractfactory.AbstractFactory;
import com.sitech.abstractfactory.IpadFactory;
import com.sitech.abstractfactory.PcFactory;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: AbstractProducer
 * @Description:
 * @date: 2019/9/20 15:03
 * @describe:
 */
public class AbstractProducer {
    public static AbstractFactory getabstractproducer(String a){
        if("ipad".equalsIgnoreCase(a)){
            return new IpadFactory();
        }else if("pc".equalsIgnoreCase(a)){
            return new PcFactory();
        }
        return null;
    }
}
