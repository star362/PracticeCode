package com.subject;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2019-12-20 16:48
 * @describe: 订阅模式
 */
public class Main {
    public static void main(String[] args) {
        final ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ObserverA());
        subject.setState(1);
    }
}
