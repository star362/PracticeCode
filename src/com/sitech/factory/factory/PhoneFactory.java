package com.sitech.factory.factory;

import com.sitech.factory.inte.ApplePhone;
import com.sitech.factory.inte.HuaWeiPhone;
import com.sitech.factory.inte.impl.Phone;


/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: PhoneFactory
 * @Description:
 * @date 2019/9/20 13:56
 * @描述   工厂模式
 */
public class PhoneFactory {
    public static Phone useFactory(String pg) {
        switch (pg){
            case "HUAWEI" : return new HuaWeiPhone();
            case "APPLE" : return new ApplePhone();
        }





        return null;
    }
}
