package com.anno.Test;

import com.anno.aop.MathCalculator;
import com.anno.config.MainConfigOfAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTestAop {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfAop.class);
        MathCalculator bean = ac.getBean(MathCalculator.class);
        int result = bean.div(2, 1);
        //System.out.println(result);
    }
}
