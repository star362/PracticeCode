package com.celue;

import com.celue.model.MoneyChinaModel;
import com.celue.model.MoneyStrategy;
import com.celue.model.UsaModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: MoneyEnum
 * @Description:
 * @date: 2019-11-22 09:44
 * @describe: 设置金额种类
 */
public enum  MoneyEnum {

    CHIAN(1,"人民币"){
        @Override
        public MoneyStrategy apply() {
            System.out.println("enum china");
            return new MoneyChinaModel();
        }
    },USA(2,"美元"){
        @Override
        public MoneyStrategy apply() {
            System.out.println("enum usa");
            return new UsaModel();
        }
    };

    private Integer code;

    private String name;

    MoneyEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }



    public String getName() {
        return name;
    }

    public abstract MoneyStrategy apply();

    public static MoneyEnum apply222(Integer e) {
       switch (e){
           case 1:
               return CHIAN;
           case 2:
               return USA;
           default:
               throw new IllegalStateException("Unexpected value: " + e);
       }


    }


}
