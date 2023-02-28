package com.thread;

import com.celue.MoneyEnum;
import java.util.concurrent.*;
import java.util.stream.LongStream;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2020-03-20 09:30
 * @describe:  线程池
 */
public class Singleton {
    public static void main(String[] args) throws InterruptedException {

        //创建单核心的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //创建固定核心数的线程池，这里核心数 = 2
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        //创建一个按照计划规定执行的线程池，这里核心数 = 2
        ExecutorService executorService3 = Executors.newScheduledThreadPool(2);
        //创建一个自动增长的线程池 缓存类型线程池
        ExecutorService executorService4 = Executors.newCachedThreadPool();
        //创建一个具有抢占式操作的线程池 1。8 之后新增 每个线程都有一个任务队列存放任务
        ExecutorService executorService5 = Executors.newWorkStealingPool(Runtime.getRuntime().availableProcessors());

        CountDownLatch countDownLatch = new CountDownLatch(Runtime.getRuntime().availableProcessors());

        // CPU 核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        LinkedBlockingDeque<Future<String>> strings = new LinkedBlockingDeque<>();


        for (int i = 0; i < Runtime.getRuntime().availableProcessors()+1; i++) {
            Future<String> submit = executorService5.submit(new Callable<String>() {
                @Override
                public String call() {
                    //System.out.println("展示线程：" + Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                    }
                    return "展示线程：" + Thread.currentThread().getName();
                }
            });
            strings.offer(submit);
        }

        countDownLatch.await();

        System.out.println("over");
        executorService5.shutdown();

        strings.forEach(f-> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });




       /* //默认线程池拒绝策略
        ExecutorService executorService6 = new ThreadPoolExecutor(2, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10),new ThreadPoolExecutor.AbortPolicy());

        LinkedBlockingDeque<Future<String>> strings1 = new LinkedBlockingDeque<>();

        for (int i = 0; i < 12; i++) {
            System.out.println("提交"+i);
            try {
                Future<String> submit = executorService6.submit(new Callable<String>() {
                    @Override
                    public String call() {
                         System.out.println("展示线程：" + Thread.currentThread().getName());
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return "展示线程:"+ Thread.currentThread().getName();
                    }
                });
                strings1.offer(submit);
            } catch (RejectedExecutionException e) {
                System.out.println("提交失败"+i);
                e.printStackTrace();
            }
        }


        executorService6.shutdown();

        while (true) {
            if (executorService6.isTerminated()) {
                System.out.println("-------HughRemindMsgMain----------->程序结束" );
                break;
            }
        }*/

        /*strings1.forEach(a-> {
            try {
                System.out.println(a.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
*/





    }




}
