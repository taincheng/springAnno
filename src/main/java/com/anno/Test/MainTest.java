package com.anno.Test;

import com.anno.beans.student;
import com.anno.config.Mainconfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args){
        //以注解的形式来得到IOC容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(Mainconfig.class);
        student student = (student) ac.getBean("student");
        System.out.println(student);
    }
}
