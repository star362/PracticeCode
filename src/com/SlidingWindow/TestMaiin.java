package com.SlidingWindow;

import java.util.Random;

/**
 * Description: <br>
 * Create Date: 2021-02-25 20:23 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class TestMaiin {

    public static void main(String[] args) {
        //1秒一个时间片，窗口共5个
        SlidingWindow window = new SlidingWindow(1000, 5, 8);
        for (int i = 0; i < 100; i++) {
            System.out.println(window.addCount(2));

            window.print();
//            System.out.println("--------------------------");
            try {

                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
