package com.anno.Test;

import com.anno.beans.student;
import com.anno.config.Mainconfig;
import com.anno.config.Mainconfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class Test01 {
    ApplicationContext ac = new AnnotationConfigApplicationContext(Mainconfig2.class);

    @SuppressWarnings("resource")
    @Test
    public void test01() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Mainconfig.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test02() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Mainconfig2.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        Object student1 = ac.getBean("student");
        Object student = ac.getBean("student");
        System.out.println(student == student1);
    }

    @Test
    public void test03() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Mainconfig2.class);
        String[] acBeanNamesForType = ac.getBeanNamesForType(student.class);
        Environment environment = ac.getEnvironment();

        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name :
                acBeanNamesForType) {
            System.out.println(name);
        }
        Map<String, student> beansOfType = ac.getBeansOfType(student.class);
        System.out.println(beansOfType);
    }

    @Test
    public void testImport() {
        printBeans(ac);
    }

    private void printBeans(ApplicationContext ac) {
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
