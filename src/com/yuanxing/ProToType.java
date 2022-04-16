package com.yuanxing;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ObjectUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author wangyu@mvtech.com.cn
 * @date: 2020-06-22 15:59
 *
 * <p>
 */
public class ProToType implements Cloneable {


    public static void main(String[] args) throws CloneNotSupportedException {



        // 使用工具类获取当前时间的字符串,格式为:yyyy-MM-dd
        String todayDateStr= DateUtil.today();
        System.out.println(todayDateStr);


        // 使用工具类获取当前时间的字符串,格式为:yyyy-MM-dd
        String todayDateSt2r= DateUtil.now();
        System.out.println(todayDateSt2r);


        System.out.println(ObjectUtil.equal(null, null));
    }

}
