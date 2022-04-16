package com.java8.lombda;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * Description: <br>
 * Create Date: 2021-01-30 18:52 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class UnaryOperatorDemo {


    public static void main(String[] args) {

        Comparator<Integer> com1 = Integer::compare;
    }
}
