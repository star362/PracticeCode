package com.callable;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2020-01-30 10:20
 * @describe:
 */
public class CallFutureMain {


    /**
     * 使用线程池获取返回
     *
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     * @return  Future 获取返回值
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);


        CallAble callAble = null;
        ExecutorService service = new ThreadPoolExecutor(3, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue(1 << 10));

        CountDownLatch countDownLatch = new CountDownLatch(3);

        LinkedList<Future<LinkedList<Cx.ReMess>>> v = new LinkedList();
        for (int i = 0; i < 3; i++) {
            System.out.println("执行任务开始(主线程)。。。" + i);

            Future<LinkedList<Cx.ReMess>> submit = service.submit( new CallAble(i + "", "mess" + i));

            v.add(submit);
            countDownLatch.countDown();
        }

        System.out.println("======");

        service.shutdown();


        for (int i = 0; i < v.size(); i++) {
            v.get(i).get().forEach(reMess -> System.out.println("返回展示code:" + reMess.getCode() + ",mess:" + reMess.getMes()));
        }


    }


}
