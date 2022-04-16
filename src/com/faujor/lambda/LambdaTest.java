package com.faujor.lambda;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: LambdaTest
 * @Description:
 * @date 2019/4/24 19:52
 * @描述
 */
public class LambdaTest {
    //测试 1.8 新特性
    public static void main(String[] args) {


        ArrayList<Student> list = new ArrayList<>();

        list.add(Student.newBuilder().age(12).name("李四").sex("男").build());
        list.add(Student.newBuilder().age(14).name("张三").sex("男").build());
        List<Student> list2 = new ArrayList<>();
        list.add(new Student("王五", 18, "女"));
        final List<Student> collect = Stream.of(list, list2).flatMap(li->{ return li.stream();}).collect(Collectors.toList());
        collect.forEach(p -> System.out.println(p));




//        System.out.println("abc".hashCode());


        /*final LinkedBlockingQueue<Object> objects = new LinkedBlockingQueue<>(1);

        System.out.println(objects.offer("q"));
        System.out.println(objects.offer("q"));
        objects.stream().forEach(o-> System.out.println(o));


        final LinkedBlockingDeque<String> strings = new LinkedBlockingDeque<>(2);
        System.out.println(strings.offerLast("1"));
        System.out.println(strings.offerFirst("2"));

        strings.stream().forEach(s-> System.out.println(s));

        System.out.println("============");
        final ArrayBlockingQueue arrayBlockingQueue = null;
//        System.out.println(arrayBlockingQueue.offer("1"));
//        System.out.println(arrayBlockingQueue.offer("2"));

        arrayBlockingQueue.forEach(s-> System.out.println(s));
        System.out.println("============");
        // 线程不安全
        ArrayDeque arrayDeque=new ArrayDeque();
        arrayDeque.offer("1");

//        单向链表结构的无界并发队列。元素操作按照 FIFO (first-in-first-out 先入先出)
        final ConcurrentLinkedQueue<Object> objects1 = new ConcurrentLinkedQueue<>();
        objects1.offer("1");

//        ConcurrentLinkedDeque 是双向链表结构的无界并发队列。与 ConcurrentLinkedQueue 的区别是该阻塞队列同时支持FIFO和FILO两种操作方式
        final ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
        concurrentLinkedDeque.offer("1");*/


        char [] c=Long.toString(12).toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}
