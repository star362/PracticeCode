package com.celue;

import com.celue.model.MoneyStrategy;
import com.celue.model.ScannEnum;
import com.loader.Person;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: Main
 * @Description:
 * @date: 2019-11-22 09:51
 * @describe:
 */
public class Main {

    //反射
    public static void main(String[] args) {


        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime of = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, 0, 0);

        final Duration between = Duration.between(of, now);
        final long x = between.toMinutes() * 60;


        final long seconds = new Random().nextInt((int) x);
//        System.out.println(seconds);
        System.out.println(of.plusSeconds(seconds).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));


        String[] ipv6={"bcb0:5890:c900::/40","ea1d:51af:6be5:7fec:5f00::/72","4691:76de:5491:3fa0:1b1c:8800::/86"};
//民族
        String[] info1={"汉族","满族"};
//        经度
//    车辆牌照
        String[] info2={"黑ACX637:","京A88888","沪ARk998","云F0000Ds"};

//        性别
        String[] info3={"男","女"};
//        手机号
        String[] info4={"13796189898","18946009803","17266994527","18876895367"};
//        地名
        String[] info5={"哈尔滨","北京","天津","上海"};
//        人名
        String[] info6={"赵云","张三","李师师","赵晓丹"};
//        网址
        String[] info7={"www.baidu.com","www.taobao.com","blog.csdn.net"};

//        邮箱
        String[] info8={"529033384@qq.com","star222@163.com","wangzhe121@163.com"};

    }


}
