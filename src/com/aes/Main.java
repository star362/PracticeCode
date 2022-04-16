package com.aes;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Description: <br>
 * Create Date: 2020-12-24 13:49 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class Main {


    public static void main(String[] args) {
        final Aes aes = new Aes();
        System.out.println(aes.desgo("Yezishuqaz123", "BOTANY",true));
        System.out.println(aes.desgo("WC9lM2dERVRQOUlFUmtTY2t3MVIwUT09", "BOTANY",false));


//
        System.out.println(aes.desgo("admin", "eWxtZkRseFhLcm04Skc0OWdGYlUwUT09",true));
        System.out.println(aes.desgo("WHp3VW52Wnl5YmZIby9nOE9wY2hrQT09", "eWxtZkRseFhLcm04Skc0OWdGYlUwUT09",false));

        Runtime.getRuntime().gc();
//        System.gc();
//        System.out.println(aes.encode("Yezishuqaz123", "BOTANY"))




//        解密
//        System.out.println(aes.decode("X/e3gDETP9IERkSckw1R0Q==","BOTANY"));
    }
}
