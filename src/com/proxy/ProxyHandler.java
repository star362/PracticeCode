package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: ProxyHandler
 * @Description:
 * @date: 2019/10/1 21:05
 * @describe:
 */
public class ProxyHandler<T> implements InvocationHandler {
    private  T obj;
    public T bind(T obj){
        this.obj=obj;
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行代理 invoke 方法");
        return method.invoke(obj,args);
    }
}
