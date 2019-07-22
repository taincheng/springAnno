package com.anno.beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("dog")
public class Dog {
    public Dog(){
        System.out.println("dog ... constructor...");
    }

    //对象创建并赋值
    @PostConstruct
    public void init(){
        System.out.println("dog... @PostConstruct....");
    }

    //对象被销毁之前执行
    @PreDestroy
    public void destory(){
        System.out.println("dog... @PreDestroy....");
    }
}
