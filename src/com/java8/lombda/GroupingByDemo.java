package com.java8.lombda;

import com.faujor.lambda.Student;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * Description: <br>
 * Create Date: 2021-01-30 11:44 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class GroupingByDemo {
    public static void main(String[] args) {
//        groupbyInfo();
//        groupbymappiing();


//        partitioningByiinfo();

    }

    private static void partitioningByiinfo() {
        List<Student> students = Arrays.asList(
                new Student("apple", 10, "男"),
                new Student("banana", 10, "男"),
                new Student("orange", 20, "男"),
                new Student("pipe", 40, "女"),
                new Student("pinck", 80, "女")
        );
        final Map<Boolean, List<Student>> collect = students.parallelStream().collect(Collectors.partitioningBy(a -> a.getAge() > 20));
        System.out.println("true"+collect.get(Boolean.TRUE));
        System.out.println("false"+collect.get(Boolean.FALSE));
    }

    private static void groupbymappiing() {
        List<Student> students = Arrays.asList(new Student("apple", 10, "男"),
                new Student("banana", 10, "男"),
                new Student("orange", 20, "男"),
                new Student("pipe", 40, "女"),
                new Student("pinck", 80, "女")
        );
        Map<String, List<Student>> collect1 = students.stream().collect(Collectors.groupingBy(Student::getSex));
        System.out.println(collect1);

        Map<String, List<Integer>> collect2 = students.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.mapping(Student::getAge, Collectors.toList())));
        final Map<String, Integer> collect = students.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.summingInt(a -> a.getAge())));
        System.out.println(collect2);
        System.out.println(collect);

        Map<String, Set<Integer>> collect3 = students.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.mapping(Student::getAge, Collectors.toSet())));
        System.out.println(collect3);
    }

    private static void groupbyInfo() {
        Supplier<HashMap<String, Object>> sup = HashMap::new;
        Supplier<LinkedList<HashMap<String, Object>>> listsup = LinkedList::new;


        final LinkedList<HashMap<String, Object>> linkedList = listsup.get();

        HashMap<String, Object> map = sup.get();
        map.put("today", "today");
        map.put("reservedValue2", "已完成");
        map.put("cou", "0");
        linkedList.add(map);

        map = sup.get();
        map.put("today", "today");
        map.put("reservedValue2", "未完成");
        map.put("cou", "12");
        linkedList.add(map);

        map = sup.get();
        map.put("today", "today");
        map.put("reservedValue2", "未完成");
        map.put("cou", "21");
        linkedList.add(map);

        map = sup.get();
        map.put("today", "yesterday");
        map.put("reservedValue2", "已完成");
        map.put("cou", "0");
        linkedList.add(map);

        map = sup.get();
        map.put("today", "yesterday");
        map.put("reservedValue2", "未完成");
        map.put("cou", "5");
        linkedList.add(map);

        final Map<String, Long> collect1 = linkedList.stream().collect(Collectors
                .groupingBy(m -> m.get("today").toString().concat(m.get("reservedValue2").toString()),
                        Collectors.mapping(m -> m.size(), Collectors.counting())
                ));


        collect1.forEach((k, v) -> {
            System.out.format("展示key:%s  展示集合: %s\n", k, v);
//            Long sun = v.stream()
//                    .collect(Collectors.summingLong(a -> Long.valueOf(a.get("cou").toString())));

            System.out.format("cou:%s \n", v);
        });


//        final IntSummaryStatistics summaryStatistics = Stream.of(1, 23, 4, 56, 7, 7).collect(Collectors.summarizingInt(a -> a));
//        final Integer summaryStatistics2 = Stream.of(1, 23, 4, 56, 7, 7).collect(Collectors.summingInt(a -> a));
//
//        System.out.println("年龄平均值：" + summaryStatistics.getAverage()); // 年龄平均值：26.0
//        System.out.println("人数：" + summaryStatistics.getCount()); // 人数：6
//        System.out.println("年龄最大值：" + summaryStatistics.getMax()); // 年龄最大值：40
//        System.out.println("年龄最小值：" + summaryStatistics.getMin()); // 年龄最小值：16
//        System.out.println("年龄总和：" + summaryStatistics.getSum()); // 年龄总和：156
//        System.out.println(summaryStatistics2);
    }
}
