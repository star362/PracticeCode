package com.demo;

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

        /****查询有多少条数据分成多线程处理****/
//        final List<ActMktfeedbackDict> actMktfeedbackDicts = feedBackSvc.finActMktfeedbackDictBetweenTime();
//
//        int runnum = 20000;//一个线程处理多少条数据
//
//        //线程数量
//        int threadnum = actMktfeedbackDicts.size() % runnum == 0 ? actMktfeedbackDicts.size() / runnum : (actMktfeedbackDicts.size() / runnum + 1);



        //循环线程数分批处理数据
//        for (int pid = 1; pid <= threadnum; pid++) {
//
//            log.error("------>定义线程池serviceList的线程 threadnum=" + threadnum + ",pid=" + pid);
//            int beg = (pid - 1) * runnum;
//            int end = pid == threadnum ? actMktfeedbackDicts.size() : pid * runnum;
//            final List<ActMktfeedbackDict> subList = actMktfeedbackDicts.subList(beg, end);
//
//            FeedBackRun cronMonthSendRun = new FeedBackRun();
//            cronMonthSendRun.setProcessNum(threadnum);
//            cronMonthSendRun.setCurNum(pid);
//            cronMonthSendRun.setDbLable(dbLabel);
//            cronMonthSendRun.setActMktfeedbackDictList(subList);
//
//            log.error("------>执行线程池serviceList的线程processNum=" + threadnum + ",pid=" + pid);
//            serviceList.execute(cronMonthSendRun);
//        }

    }

}
