package com.demo;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description: <br>
 * Create Date: 2022/2/21 下午7:21 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class TestDemo {





    public static void main(String args[]){

        //        查询需要处理的数据,大于两万条分批处理
        Long totalCount = 23111L;

        Long batchSize = 20000L;

        //需要循环查询几次
        Long fnum = totalCount % batchSize == 0 ? totalCount / batchSize : (totalCount / batchSize + 1);

        for (long pid = 1; pid <= fnum; pid++) {
            long beg = (pid - 1) * batchSize;
            long end = pid == fnum ? totalCount : pid * batchSize;

            System.out.println(StrUtil.format("beg:{}===end:{}", beg, end));
        }

    }

}
