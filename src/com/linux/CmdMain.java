package com.linux;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

/**
 * Description: 斐波那契数列<br>
 * Create Date: 2020-09-15 09:56 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class CmdMain {


    public static void main(String[] args) throws IOException {



    }


    /**
     * 自顶向下
     * @param n
     * @return
     */
    public static int f(int n){
        if (n<=0) {
            return -1;
        }
        if(n==1||n==2) {
            return 1;
        }
        return f(n-1)+f(n-2);
    }


    /**
     * 自低向上
     * @param n
     * @return
     */
    public static int f2(int n){
        if (n<=0) {
            return -1;
        }
        if(n==1||n==2) {
            return 1;
        }

        int a = 1,b=1;
        int nuumb=0;

        for (int i=3;i<=n;i++){
            nuumb=a+b;
            a=b;
            b=nuumb;
        }
        return nuumb;
    }



}
