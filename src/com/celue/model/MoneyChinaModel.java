package com.celue.model;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: MoneyChinaModel
 * @Description:
 * @date: 2019-11-22 10:53
 * @describe:
 */
public class MoneyChinaModel implements MoneyStrategy {
    @Override
    public void apply() {
        System.out.println("MoneyChinaModel");
    }
}
