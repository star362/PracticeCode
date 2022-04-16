package com.mvtech;

import java.util.Arrays;
import java.util.Random;

/**
 * Description: <br>
 * Create Date: 2020-09-09 19:56 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class diguiTest {
    public static void main(String[] args) {
        final byte[] bytes = "中".getBytes();

        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }


    }





   /* private static int getIdString(int info) {
        //随机替换
        final Random random = new Random();
        int i = random.nextInt(2);
        System.out.println(i);
        if (i == info) {
            i = getIdString(info);
        }
        return i;

    }*/
}
