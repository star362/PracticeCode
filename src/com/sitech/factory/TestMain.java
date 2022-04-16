package com.sitech.factory;


import com.sitech.factory.factory.PhoneFactory;
import com.sitech.factory.inte.impl.Phone;
import com.utils.LocalDateUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: TestMain
 * @Description:
 * @date: 2019/9/20 14:14
 * @describe: 工厂模式
 */
public class TestMain {



    public static void main(String[] args) {
        /*System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.vendor"));
        System.out.println(System.getProperty("java.vendor.url"));
        System.out.println(System.getProperty("java.vm.name"));*/

        DateTimeFormatter formatddaata = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime localDateTime=LocalDateTime.now();
//        System.out.println(localDateTime);
        final LocalDateTime seconds = localDateTime.plusSeconds(1);


        final String format = formatddaata.format(seconds);
        final String format2 = formatddaata.format(seconds.minusSeconds(2));

        final HashMap<String, String> objectObjectHashMap = new HashMap<>();

        System.out.println(format);
        System.out.println(format2);

        objectObjectHashMap.put("end",format);
        objectObjectHashMap.put("beginDate",format2);

        System.out.println(objectObjectHashMap);

//        final String endTime = df.format(seconds);
//        final String begintime = df.format(seconds.minusSeconds(thresholdExecTimeLength));




    }

}
