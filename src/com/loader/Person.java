package com.loader;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangyu_bill@si-tech.com.cn
 * @date: 2020-03-06 18:15
 * @describe:
 * {@link #saa()}
 * @see #saa()
 * @Value 1
 */
public class Person implements IPersion, Callable<Integer>, Serializable {
    String name;

    private int age;

    protected String sex;

    public String zNmae;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getzNmae() {
        return zNmae;
    }

    public void setzNmae(String zNmae) {
        this.zNmae = zNmae;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public Person() {
        System.out.println("null Persion");
    }

    public Person(String name, int age, String sex, String zNmae) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.zNmae = zNmae;
        System.out.println("all Persion");
    }

    private Person(Builder builder) {
        name = builder.name;
        age = builder.age;
        sex = builder.sex;
        zNmae = builder.zNmae;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public void publicfa(){
        System.out.println("public function");

    }

    /**
     * {@link #saa()}
     * @param a
     */
    private static void privatefas(String a){
        System.out.println("private method ==="+a);

    }
    public void saa(){
        System.out.println("null method");
    }


    private ReentrantLock lock=new ReentrantLock(false);

    @Override
    public Integer call() {
        lock.lock();
        try {
            for (int i = 0; i < 1000; i++) {
                age++;
//                System.out.println("======"+age);
            }
        } finally {
            lock.unlock();
        }
//        System.out.println("over======"+age);
        return age;
    }



    public static final class Builder {
        private String name;
        private int age;
        private String sex;
        private String zNmae;

        private Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder sex(String val) {
            sex = val;
            return this;
        }

        public Builder zNmae(String val) {
            zNmae = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", zNmae='" + zNmae + '\'' +
                ", lock=" + lock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;}
        Person edgs = (Person) o;
        return Objects.equals(zNmae, edgs.zNmae) &&
                Objects.equals(age, edgs.age);

//        提速
//        return  Objects.equals(sip, edgs.sip) &&
//                Objects.equals(dip, edgs.dip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zNmae, age);
    }
}
