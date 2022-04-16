package com.subject2;


import java.util.Observable;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2020-01-13 09:14
 * @describe: 魔板模式
 */
public class RealSubject extends Observable {
    private  String courseName;

    public RealSubject(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void produceQuestion(RealSubject course,Question question){
        System.out.println(question.getUserName()+"在"+course.courseName+"提交了问题:"+Thread.currentThread().getName());
        setChanged();
        notifyObservers(question);
    }
}
