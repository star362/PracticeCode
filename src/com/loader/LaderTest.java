package com.loader;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2020-02-21 09:51
 * @describe:
 */
public class LaderTest {

    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ParseException {
       /* final Class<Person> personClass = Person.class;

        final Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        final Person person = declaredConstructor.newInstance();
        System.out.println(person.toString());
        final Field sex = personClass.getDeclaredField("sex");
        sex.setAccessible(true);
        sex.set(person,"man2");
        System.out.println(person.toString());
        final Method saa = personClass.getDeclaredMethod("privatefas",String.class);
        saa.setAccessible(true);
        saa.invoke(person,"privatefas");*/

        String d = "2020-10-10";
        System.out.println(simpleDateFormat.parse(d).toInstant().toEpochMilli() * 1000L);


        Date date = simpleDateFormat.parse(d);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();

        System.out.println(date.toInstant().toEpochMilli() * 1000L);

    }
}
