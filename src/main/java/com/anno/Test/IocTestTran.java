package com.anno.Test;

import com.anno.tx.TxConfig;
import com.anno.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTestTran {

    @Test
    public void Test01(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService bean = ac.getBean(UserService.class);
        bean.insertUser();
    }
}
