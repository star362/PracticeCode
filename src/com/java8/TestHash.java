package com.java8;

import com.faujor.lambda.Student;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: TestHash
 * @Description:
 * @date: 2019-10-07 22:30
 * @describe:
 */
public class TestHash {

    /**
     * java8中规范的四大函数式接口：
     * <p>
     * 1、Consumer<T>   :消费型接口    void accept(T t);
     * <p>
     * 2、Supplier<T>      :供给型接口    T get();
     * <p>
     * 3、Function<T,R>   :函数型接口    R apply(T t);
     * <p>
     * 4、Predicate<T>    :断言型接口    boolean test(T t);
     *
     * @param args
     */

    public static void main(String[] args) {


        System.out.println("=========");
        assert false;

        System.out.println("--------------");



    }


    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        if (digits.length() != 0){
            backtrack(result, "", digits);
        }
        return result;
    }

    public static void backtrack(List<String> result, String condition, String next_digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        if (next_digits.length() == 0) {
            result.add(condition);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(result, condition + letter, next_digits.substring(1));
            }
        }
    }





}
