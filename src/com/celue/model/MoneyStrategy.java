package com.celue.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: MoneyStrategy
 * @Description:
 * @date: 2019-11-22 11:17
 * @describe:
 */
@FunctionalInterface
public interface MoneyStrategy {


    void apply();
}
