package com.java8.lombda;

import com.faujor.lambda.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * Description: <br>
 * Create Date: 2021/3/10 9:31 上午 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class StreamDemo {
    static List<Student> students = null;


    StreamDemo() {
        System.out.println("=====");

    }


    public static void main(String[] args) {
//        streamSum();
//        generate();
//        allMatch();
//        amymatch();
//        keep();

        students = Arrays.asList(
                new Student("apple", 10, "男"),
                new Student("banana", 10, "男"),
                new Student("orange", 20, "男"),
                new Student("pipe", 40, "女"),
                new Student("pinck", 80, "女")
        );

        final List<Boolean> aaa = students.stream().map(s -> s.getSex().equalsIgnoreCase("男")).collect(toList());
        final String collect = students.stream().collect(mapping(Student::getSex, joining(",")));

        System.out.println(aaa);
        System.out.println(collect);


    }

    private static void keep() {
        //        Stream.of("one", "two", "three", "four").peek(e -> System.out.println(e)).collect(Collectors.toList());

        Stream.of("one", "two", "three", "four").filter(a->true).peek(e -> System.out.println(e));

//        System.out.println(collect);
    }


    private static void amymatch() {
        students = Arrays.asList(
                new Student("apple", 10, "男"),
                new Student("banana", 10, "男"),
                new Student("orange", 20, "男"),
                new Student("pipe", 40, "女"),
                new Student("pinck", 80, "女")
        );

//        返回此流的任何元素是否与提供的谓词匹配
        boolean flag = students.stream().anyMatch(stu -> stu.getAge() > 18);
        System.out.println(flag);
    }

    private static void allMatch() {
        students = Arrays.asList(
                new Student("apple", 10, "男"),
                new Student("banana", 10, "男"),
                new Student("orange", 20, "男"),
                new Student("pipe", 40, "女"),
                new Student("pinck", 80, "女")
        );

//        IntStream.iterate(2, n -> n * 3).limit(10).forEach(System.out::println);
        //判断学生年龄是否都大于18
        boolean flag = students.stream().allMatch(stu -> stu.getAge() > 18);
        System.out.println(flag);
    }


    /**
     * 通过流无限创建对象
     */
    private static void generate() {

        Stream.generate(Random::new).forEach(r -> System.out.println(r.nextInt(100)));
    }

    private static void streamSum() {
        students = Arrays.asList(
                new Student("apple", 10, "男"),
                new Student("banana", 10, "男"),
                new Student("orange", 20, "男"),
                new Student("pipe", 40, "女"),
                new Student("pinck", 80, "女")
        );
        final int sexnum = students.stream().filter(s -> s.getSex().equalsIgnoreCase("男")).mapToInt(Student::getAge).sum();

        System.out.println(sexnum);
    }


}
