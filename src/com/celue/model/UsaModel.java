package com.celue.model;


/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: UsaModel
 * @Description:
 * @date: 2019-11-22 10:54
 * @describe:
 */
public class UsaModel extends MoneyChinaModel {
    public UsaModel() {
//        System.out.println("构造");
    }

//    {
//        System.out.println("init");
//    }

//    static {
//        System.out.println("static");
//    }
    @Override
    public void apply() {
        System.out.println("UsaModel");
    }

    public static void apply2() {
        System.out.println("UsaModel2");
    }


}
