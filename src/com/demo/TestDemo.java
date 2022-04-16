package com.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description: <br>
 * Create Date: 2022/2/21 下午7:21 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class TestDemo {





    public static void main(String args[]){

        String str="adchm";
        final String solve = solve(str);
        System.out.println(solve);




    }

    public static String solve (String str) {
        String rstr="";
        final char[] chars = str.toCharArray();
        LinkedList l=new LinkedList();
        for (char aChar : chars) {
            l.push(aChar);
        }

        while (!l.isEmpty()){
            final Object poll = l.pollLast();
            rstr+= poll;
            System.out.println(poll);
        }

        return rstr;
    }
}
