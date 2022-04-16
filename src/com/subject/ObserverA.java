package com.subject;

/**
 * 观察者模式：观察者 实现
 *
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2019-12-20 16:40
 * @describe:
 */
public class ObserverA implements Observer {

    //myState需要跟目标对象的state值保持一致！
    private int myState;

    /**
     * 更新为和目标对象的值一致
     */
    @Override
    public void update() {
        System.out.println("ObserverA状态变更");
    }

    public int getMyState() {
        return myState;
    }
    public void setMyState(int myState) {
        this.myState = myState;
    }





}



