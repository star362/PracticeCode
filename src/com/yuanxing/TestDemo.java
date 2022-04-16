package com.yuanxing;

import com.celue.model.MoneyStrategy;
import com.celue.model.UsaModel;

import java.lang.reflect.InvocationTargetException;

/**
 * @author wangyu@mvtech.com.cn
 * @date: 2020-08-18 20:53
 *
 * <p>
 */
public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        final ProToType proToType = new ProToType();
        final long l1 = System.currentTimeMillis();
        for (int i=0;i<=1000000;i++){
//            final ProToType clone = proToType.clone();
        }
        final long l2 = System.currentTimeMillis();
        System.out.format("克隆消耗时间%s ms",(l2-l1));
        System.out.println();
        final long l3 = System.currentTimeMillis();
        for (int i=0;i<=1000000;i++){
            final ProToType clone =  new ProToType();
        }
        final long l4 = System.currentTimeMillis();
        System.out.format("new耗时间%s ms",(l4-l3));


        System.out.println();
        final long l5 = System.currentTimeMillis();
        for (int i=0;i<=1000000;i++) {
            final MoneyStrategy o = (MoneyStrategy) Class.forName("com.celue.model.UsaModel").getDeclaredConstructor().newInstance();
        }
        final long l6 = System.currentTimeMillis();
        System.out.format("反射耗时间%s ms",(l6-l5));

    }
}
