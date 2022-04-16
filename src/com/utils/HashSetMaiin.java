package com.utils;

import com.faujor.lambda.Student;
import com.loader.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description: <br>
 * Create Date: 2020-12-26 13:58 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class HashSetMaiin {

    public static void main(String[] args) {
//        final HashSet<Person> objects = new HashSet<>();
//        objects.add(Person.newBuilder().age(1).name("11").sex("111").build());
//        objects.add(Person.newBuilder().age(1).name("11").sex("111").build());
//        objects.add(Person.newBuilder().age(2).name("22").sex("222").build());
//        Map<Integer, Person> collect = objects.stream().collect(Collectors.toMap(Person::getAge, person -> person));


        //创建集合
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
//使用stream流进行分组
        Map<Boolean, List<Integer>> preAvg = list.stream()
                .collect(Collectors.groupingBy(x -> x < 2 || x > 4));
        List<Integer> tr = preAvg.get(true);
        List<Integer> fa = preAvg.get(false);
        System.out.println("true" + tr);
        System.out.println("false" + fa);
//使用filter过滤
//        List<Integer> collect = list.stream().filter(x -> x < 2 || x > 4))
//                .collect(Collectors.toList());
//输出满足过滤条件的集合数据
//        System.out.println("true" + collect);


    }
}
