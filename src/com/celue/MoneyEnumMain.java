package com.celue;

import com.celue.model.MoneyStrategy;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @author wangyu@mvtech.com.cn
 * @date: 2020-08-10 09:45
 *
 * <p>
 */
public class MoneyEnumMain {

    public static void main(String[] args) {
//        final MoneyStrategy apply = MoneyEnum.CHIAN.apply();

        final EnumSet<MoneyEnum> moneyEnums = EnumSet.allOf(MoneyEnum.class);

        moneyEnums.stream().forEach(e-> {
            System.out.println(e);
            System.out.println(MoneyEnum.apply222(e.getCode()));
        });



        final EnumMap enumMap = new EnumMap(MoneyEnum.class);
        enumMap.put(MoneyEnum.CHIAN,1);
        enumMap.put(MoneyEnum.USA,2);

        System.out.println(enumMap.containsValue(3));

    }
}
