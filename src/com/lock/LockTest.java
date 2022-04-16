package com.lock;

import com.java8.DateTimeUtils;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wangyu@mvtech.com.cn
 * @date: 2020-06-11 10:52
 *
 * <p>
 * 练习使用公平锁
 */
public class LockTest {


    public static void main(String[] args) throws InterruptedException, ExecutionException, UnsupportedEncodingException {


        LocalDateTime localDateTime = LocalDateTime.of(2021, 03, 02, 11, 11, 11);
        //3秒出现五次
        int miisoshuu = 7;
        int cou = 15;

        //前后三秒
        LocalDateTime localDateTime1 = localDateTime.minusSeconds(miisoshuu);
        LocalDateTime localDateTime12 = localDateTime.minusSeconds(miisoshuu);

        LocalDateTime localDateTime2 = localDateTime.plusSeconds(miisoshuu);


        final HashMap<String, Integer> hashMap = new HashMap(1 << 4) {{
            put("20210302111111", 1);
            put("20210302111112", 4);
            put("20210302111114", 0);
            put("20210302111109", 1);
            put("20210302111110", 2);
            //
        }};


//        创建三个数组
        LinkedBlockingDeque<Integer> linkedBlockingQueue = new LinkedBlockingDeque(miisoshuu);

        int num = 0;


//        Duration duration = Duration.between(localDateTime1,localDateTime2);
//        System.out.println(duration.toMillis());
//        String overDate = "";
        ;
        while (localDateTime1.isBefore(localDateTime2) && num < cou) {

            if (localDateTime1.isBefore(localDateTime) && num < cou) {
                localDateTime1 = localDateTime1.plusSeconds(1);
                linkedBlockingQueue.offerLast(hashMap.getOrDefault(DateTimeUtils.formatLocalDateTime(localDateTime1, "yyyyMMddHHmmss"), 0));
                num += hashMap.getOrDefault(DateTimeUtils.formatLocalDateTime(localDateTime1, "yyyyMMddHHmmss"), 0);

            } else if (num < cou) {
                num = num - linkedBlockingQueue.pollFirst();
                localDateTime1 = localDateTime1.plusSeconds(1);
                final Integer orDefault = hashMap.getOrDefault(DateTimeUtils.formatLocalDateTime(localDateTime1, "yyyyMMddHHmmss"), 0);
                linkedBlockingQueue.offerLast(orDefault);
                num += orDefault;

//                System.out.println("yyyyMMddHHmmss" + overDate);
            } else {
                break;
            }


        }


        System.out.println("over" + num);
        System.out.println("beginDate" + DateTimeUtils.formatLocalDateTime(localDateTime12, "yyyyMMddHHmmss"));
//        final String s = overDate.equals("") ? DateTimeUtils.formatLocalDateTime(localDateTime1) : overDate;
        final String s = DateTimeUtils.formatLocalDateTime(localDateTime1);
        System.out.println("over Date" + s);

    }


}
