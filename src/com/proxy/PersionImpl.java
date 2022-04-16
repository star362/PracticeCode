package com.proxy;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: PersionImpl
 * @Description:
 * @date: 2019/10/1 21:04
 * @describe:
 */
public class PersionImpl implements Persion {
    @Override
    public void eat() {
        System.out.println("执行PersionImpl eat");
    }

    @Override
    public void say() {
        System.out.println("执行PersionImpl say");
    }
}
