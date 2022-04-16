package com.subject2;

import java.util.Observable;
import java.util.Observer;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2020-01-13 09:15
 * @describe:
 */
public class RealObserver implements Observer {


    private String teacherName;

    public RealObserver(String teacherName) {
        this.teacherName = teacherName;
    }


    @Override
    public void update(Observable o, Object arg) {
        RealSubject course=(RealSubject)o;
        Question question=(Question)arg;
        System.out.println(teacherName+"老师的"+course.getCourseName()+"课程接收到一个"+question.getUserName()+"提交的问答："+question.getQuestionContent()+":"+Thread.currentThread().getName());

    }
}
