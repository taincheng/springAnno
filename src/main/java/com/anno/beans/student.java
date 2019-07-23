package com.anno.beans;

import org.springframework.beans.factory.annotation.Value;

public class student {

    //使用@Value赋值：
    //1.基本数值
    //2.可以写SpEL：#{}
    //3.可以写${}:取出配置文件[properties]中的值（在运行环境变量里面的值）

    @Value("admin")
    private String name;
    @Value("#{20-2}")
    private int age;

    @Value("${privateName}")
    private String privateName;

    public String getPrivatename() {
        return privateName;
    }

    public void setPrivatename(String privatename) {
        this.privateName = privatename;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", privateName='" + privateName + '\'' +
                '}';
    }

    public student(){

    }

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}
