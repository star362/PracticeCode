package com.java8;

/**
 * Description: <br>
 * Create Date: 2020-12-08 17:06 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public abstract class AbstractClass {

    //基本方法
    protected abstract void domethod1();
    //基本方法
    protected abstract void domethod2();
    //模板方法
    public final void templateMethod(){
        /*
         *调用基本方法完成相关逻辑
         */
        this.domethod1();
        this.domethod2();
    }

}
