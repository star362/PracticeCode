package com.queue;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wangyu
 * @date: 2020-04-30 12:39
 *
 * <p>
 * 练习队列
 */
public class QueueDemo {


    public static void main(String[] args) {


        //非阻塞队列
        LinkedList<String> objects = new LinkedList<>();
        String s1 = objects.peekFirst();
        String s = objects.pollLast();
        objects.add("a");
        objects.add("a");
        objects.add("b");
        objects.add("c");


        LinkedBlockingDeque<String> linkedBlockingQueue = new LinkedBlockingDeque(10);

        linkedBlockingQueue.offer("b");
        linkedBlockingQueue.addFirst("a1");
        linkedBlockingQueue.offer("c");
        linkedBlockingQueue.addLast("a");
        linkedBlockingQueue.offer("d");


//        linkedBlockingQueue.pollFirst();
//        linkedBlockingQueue.pollLast();
//        Iterator<String> iterator = linkedBlockingQueue.iterator();
//        iterator.forEachRemaining(System.out::println);


        final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue();

        queue.offer("2");
        queue.add("1");

//        queue.peek();
//        queue.poll();


//        Iterator<String> iterator2 = queue.iterator();
//        iterator2.forEachRemaining(System.out::println);


        ArrayDeque deque=new ArrayDeque<>(2);

        deque.addLast(1);
        deque.addLast(12);
        deque.addLast(123);

        deque.forEach(System.out::println);

//0?(13|14|15|18)[0-9]{9}
    }
}
