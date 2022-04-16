package com.sitech.abstractfactory;

import com.sitech.abstractfactory.producer.AbstractProducer;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: TestMain
 * @Description:
 * @date: 2019/9/20 15:00
 * @describe: 工厂模式
 */
public class TestMain {
    public static void main(String[] args) {
        //获取 pc 工厂
        AbstractFactory pcFactory=AbstractProducer.getabstractproducer("pc");
        pcFactory.abstractGetPC("apple").pcBrand();
        pcFactory.abstractGetPC("huashuo").pcBrand();
        //获取 ipad 工厂
        AbstractFactory ipadfactory=AbstractProducer.getabstractproducer("ipad");
        ipadfactory.abstractGetIpad("huawei").ipadBrand();
        ipadfactory.abstractGetIpad("apple").ipadBrand();
        ipadfactory.abstractGetIpad("xiaomi").ipadBrand();
    }
}
