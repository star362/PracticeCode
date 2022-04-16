package com.callable;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2020-01-30 10:20
 * @describe:  多线程 使用 callablse 获取返回值 FutureTask
 */
public class CallFutreTaskMain {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);


        CallAble callAble = null;
        FutureTask<LinkedList<Cx.ReMess>> ft = null;
        LinkedList<Future<LinkedList<Cx.ReMess>>> v = new LinkedList();
        for (int i = 0; i < 3; i++) {

            System.out.println("执行任务开始(主线程)。。。" + i);

            ft=new FutureTask<>(new CallAble(i + "", "mess" + i));

            new Thread(ft).start();
            v.add(ft);
        }


        for (int i = 0; i < v.size(); i++) {
            v.get(i).get().forEach(reMess -> System.out.println("返回展示code:" + reMess.getCode() + ", mess:" + reMess.getMes()));
        }

    }


}
