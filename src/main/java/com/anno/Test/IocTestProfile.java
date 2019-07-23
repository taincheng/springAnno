package com.anno.Test;

import com.anno.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class IocTestProfile {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

    /*
    1.使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
    2.使用代码的方式，激活某种环境。
            调用AnnotationConfigApplicationContext的无参构造器来
            达到先设置环境的目的。
     */

    @Test
    public void Test01(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        //1.创建一个无参applicationContext
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","Dev");
        //3.注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4.启动刷新容器
        applicationContext.refresh();

        String[] names = applicationContext.getBeanNamesForType(DataSource.class);
        for (String data: names) {
            System.out.println(data);
        }
    }
}
