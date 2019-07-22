package com.anno.Test;

import com.anno.beans.Cat;
import com.anno.beans.Dog;
import com.anno.beans.car;
import com.anno.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTestLifeCycle {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建好了。。。。");
        car bean = (car) applicationContext.getBean("car");
        Cat cat = (Cat) applicationContext.getBean("cat");
        Dog dog = (Dog) applicationContext.getBean("dog");
        System.out.println("容器关闭。。。。。");
        applicationContext.close();
    }
}
