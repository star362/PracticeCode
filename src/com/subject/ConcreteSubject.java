package com.subject;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2019-12-20 16:38
 * @describe:
 */
public class ConcreteSubject implements Subject<Observer> {


    // 存储订阅者
    List<Observer> list = new LinkedList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        //主题对象(目标对象)值发生了变化，请通知所有的观察者
        this.notifyAllObservers();
    }

    @Override
    public void notifyAllObservers() {
        for (Observer obs : list) {
            // 更新每一个观察者中的信息
            obs.update();
        }
    }

    @Override
    public void registerObserver(Observer obs) {
        list.add(obs);
    }


    @Override
    public void removeObserver(Observer obs) {
        list.remove(obs);
    }
}