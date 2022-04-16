package com.callable;

import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2020-01-30 10:26
 * @describe:
 */
public class CallAble implements Callable<LinkedList<Cx.ReMess>> {
    @Deprecated
    public String code;
    public String messagel;

    @Override
    public LinkedList<Cx.ReMess> call() throws Exception {
        System.out.println("执行任务开始(子线程)。。。" + Thread.currentThread().getName());
        Thread.sleep(5000);
        LinkedList<Cx.ReMess> chuli = new Cx().chuli(code, messagel);
        System.out.println("执行任务结束(子线程)。。。" + Thread.currentThread().getName());
        return chuli;
    }


    public CallAble(String code, String messagel) {
        this.code = code;
        this.messagel = messagel;
    }

}
