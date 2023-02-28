package com.demo;

import com.java8.DateTimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description: <br>
 * Create Date: 2021/3/28 6:00 下午 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class Demo01 {


    private static Matcher Matcherm;

    public static void main(String[] args) throws ParseException {

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-03-04 22:22:22.001233"));


    }

}
