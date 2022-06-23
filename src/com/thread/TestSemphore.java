package com.thread;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * <p>
 *
 * </p>
 *
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/6/22 11:15
 */
public class TestSemphore {

    private static SemaphorePool semaphorePool = new SemaphorePool();

    private static class TokenThread extends Thread {
        @Override
        public void run() {
            // 获取当前时间
            long start = System.currentTimeMillis();
            // 获取连接，在这里需要获取令牌才能继续往下走
            ConnectBean connectBean = semaphorePool.getConnect();
            connectBean.doSomeThing();
            // 释放连接，归还令牌
            semaphorePool.releaseConnect(connectBean);
            System.out.println("Thread:" + Thread.currentThread().getName() + "归还连接，总计持有时间： " + (System.currentTimeMillis() - start) + "ms");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new TokenThread().start();
        }
    }
}

class ConnectBean {
    public ConnectBean() {
        System.out.println("ConnectBean 生成完成");
    }

    public void doSomeThing() {
        try {
            Random r = new Random();
            Thread.sleep(2000 + r.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SemaphorePool {
    private static LinkedList<ConnectBean> list = new LinkedList<>();

    private static final int POOL_SIZE = 10;

    /**
     * 可用的连接数
     */
    private static Semaphore canUse;

    public SemaphorePool() {
        canUse = new Semaphore(POOL_SIZE);
    }

    /**
     * 初始化线程池
     */
    static {
        for (int i = 0; i < POOL_SIZE; i++) {
            list.add(new ConnectBean());
        }
    }

    public ConnectBean getConnect() {
        ConnectBean connectBean = null;

        try {
            // 获取许可证
            canUse.acquire();

            // 安全取出第一个连接
            synchronized (list) {
                connectBean = list.removeFirst();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connectBean;
    }

    public void releaseConnect(ConnectBean connectBean) {
        if (connectBean != null) {
            System.out.println("当前有" + canUse.getQueueLength() + "个线程在排队   "
                    + "可用连接数:" + canUse.availablePermits());

            synchronized (list) {
                // 重新添加回队列中
                list.addLast(connectBean);
            }
            // 释放令牌
            canUse.release();
        }
    }

}
