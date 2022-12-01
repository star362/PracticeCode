package com.Hutool;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.HashUtil;
import com.celue.MoneyEnum;
import com.java8.DateTimeUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.HashMap;

/**
 * Description: <br>
 * Create Date: 2021/5/27 4:51 下午 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class DateMain {

    public static void main(String[] args) {

        /*final LocalDateTime localDateTime = DateTimeUtils.parseLocalDateTime("2021-06-07 16:57:02", DatePattern.NORM_DATETIME_PATTERN);
        String rtime=localDateTime.getYear()+"年"+localDateTime.get(ChronoField.MONTH_OF_YEAR)+"月"+localDateTime.getDayOfMonth()+"日"+ " "+ DateTimeUtils.formatLocalDateTime(localDateTime,DatePattern.NORM_TIME_PATTERN);
        System.out.println(rtime);*/

        Dict dict = Dict.create()
                .set("key1", 1)//int
                .set("key2", 1000L)//long
                .set("key3", DateTime.now());//Date

        System.out.println(dict.getLong("key2"));
        System.out.println(dict.get("key2", HashMap.class));


    }
}
