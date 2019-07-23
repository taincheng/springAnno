package com.anno.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "Boss")
public class Boss {

    @Autowired
    //构造器上，也是使用IOC容器中的对象
    public Boss(car car) {
        this.car = car;
    }

    private car car;

    public com.anno.beans.car getCar() {
        return car;
    }

    //@Autowired
    //标注在方法，Spring容器创建当前对象的时候，就会完成赋值
    //方法使用的参数，自定义类型的值从IOC容器中获取
    public void setCar(car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
