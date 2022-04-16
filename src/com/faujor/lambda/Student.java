package com.faujor.lambda;



/**
 * @author WANGYU
 * @ProjectName PracticeCode
 * @Class: Person
 * @Description:
 * @date 2019/4/24 19:53
 * @描述
 */
public  class Student {




    private   String name;
    public  Integer age;
    private String sex;

    private Student(Builder builder) {
        setName(builder.name);
        setAge(builder.age);
        setSex(builder.sex);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Student(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public static final class Builder {
        private String name;
        private Integer age;
        private String sex;

        private Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder sex(String val) {
            sex = val;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (!name.equals(student.name)) return false;
        if (!age.equals(student.age)) return false;
        return sex.equals(student.sex);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + sex.hashCode();
        return result;
    }
}
