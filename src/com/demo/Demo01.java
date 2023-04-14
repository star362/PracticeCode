package com.demo;

import cn.hutool.core.util.StrUtil;

/**
 * Description: <br>
 * Create Date: 2021/3/28 6:00 下午 <br>
 *
 * @author wangyu@mvtech.com.cn
 */
public class Demo01 {


    public static void main(String[] args) {
        System.out.println("======");
//        int size = 20000;
//        int snum = 40001;
//        int cs = size % snum == 0 ? 1 : (snum / size) + 1;
//        getPageLimitGroupList(snum,size);
//        System.out.println(cs);


        BooleanLambdaNew booleanLambdaNew = new BooleanLambdaNew();
        Boolean a1 = booleanLambdaNew.test(()->false);
        System.out.println(a1);


    }

    public static void getPageLimitGroupList(Integer totalCount, Integer batchSizeLimit) {
        System.out.println(StrUtil.format("这一次处理的总数据条数为 ={} 条, 每一批次处理条数为 ={} 条,现在开始做分批切割处理。", totalCount, batchSizeLimit));
        int pageNum = totalCount / batchSizeLimit;
        int surplus = totalCount % batchSizeLimit;
        if (surplus > 0) {
            pageNum = pageNum + 1;
        }
        for (int i = 0; i < pageNum; i++) {
            Integer currIndex = i * batchSizeLimit;
            System.out.println(StrUtil.format("分批切割,第= {}次,每次= {} 条,最终会处理到={}条。", i, batchSizeLimit, currIndex + batchSizeLimit));

        }
        System.out.println(StrUtil.format("这一次处理的总数据条数为 = {} 条, 每一批次处理条数为 = {} 条,总共切割分成了 = {} 次,一切准备就绪,可以开始批量插入。",
                totalCount, batchSizeLimit, 11));
    }

}
