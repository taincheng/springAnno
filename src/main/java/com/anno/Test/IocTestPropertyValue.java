package com.anno.Test;

import com.anno.beans.red;
import com.anno.beans.student;
import com.anno.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IocTestPropertyValue {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);

    @Test
    public void Test01(){
        printBeans(ac);
        System.out.println("===========");
        student student = (student) ac.getBean("jack");
        System.out.println(student);

        System.out.println("=== 从环境中拿属性值 ===");
        ConfigurableEnvironment environment = ac.getEnvironment();
        String name = environment.getProperty("privateName");
        System.out.println(name);
    }

    private void printBeans(ApplicationContext ac) {
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
