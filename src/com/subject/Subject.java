package com.subject;

import java.util.LinkedList;
import java.util.List;

/**
 * 观察者模式：目标对象模板
 *
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2019-12-20 16:30
 * @describe:
 */
public interface Subject<T> {
   

    // 注册订阅者
     void registerObserver(T obs);

    // 移除订阅者
     void removeObserver(T obs);

    //通知所有的观察者更新状态
     void notifyAllObservers();
}
