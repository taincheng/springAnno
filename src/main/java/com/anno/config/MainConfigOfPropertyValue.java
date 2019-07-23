package com.anno.config;

import com.anno.beans.student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = "com.anno.beans")
//配置外部配置文件,保存到运行的环境变量中。
@PropertySource(value = {"classpath:student.properties"})
public class MainConfigOfPropertyValue {

    @Bean("jack")
    public student getStudent(){
        return new student();
    }
}
