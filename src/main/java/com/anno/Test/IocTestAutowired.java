package com.anno.Test;

import com.anno.beans.Boss;
import com.anno.beans.car;
import com.anno.config.MainConfigOfAutowired;
import com.anno.dao.studentDao;
import com.anno.service.studentService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTestAutowired {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @Test
    public void test01(){
        studentService service = ac.getBean(studentService.class);

        System.out.println(service);

        //Object dao = ac.getBean("studentDao2");
        //spring会报错，因为有两个对象,需要指定优先级
        studentDao bean = ac.getBean(studentDao.class);

        System.out.println(bean);

    }

    @Test
    public void test02(){
        Boss boss = (Boss)ac.getBean("Boss");
        System.out.println(boss);

        car car = ac.getBean(car.class);
        System.out.println(car);
    }
}
