package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Description: es 时间戳 <br>
 * Create Date: 2020-12-26 12:42 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class TimeC {

    public static void main(String[] args) throws ParseException {
        String indate="2006-10-15";
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final long ret = simpleDateFormat.parse(indate).toInstant().toEpochMilli() * 1000L;
        System.out.println(ret);

        Date date = simpleDateFormat.parse(indate);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 3);
        date = calendar.getTime();
        System.out.println(date.toInstant().toEpochMilli() * 1000L);

        System.out.println(System.identityHashCode(indate));
    }
}
