package com.anno.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("dog")
public class Dog implements ApplicationContextAware {
    private ApplicationContext ac;
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
    //ApplicationContextAware 将IOC容器注入到组件中。
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac = applicationContext;
    }
}
