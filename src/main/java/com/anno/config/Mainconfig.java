package com.anno.config;

import com.anno.beans.student;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/*
*配置类 == 配置文件
* 告诉spring 这是一个配置类
*/
@Configuration
//@ComponentScan(value = "com.anno")
//@ComponentScan(value = "com.anno",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,
//        classes = {Controller.class, Service.class})
//})
//@ComponentScan(value = "com.anno",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,
//        classes = {Controller.class})}, useDefaultFilters = false)

@ComponentScans({
        @ComponentScan(value = "com.anno",includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        },useDefaultFilters = false)
})

public class Mainconfig {

    //给容器注册一个Bean，类型为返回值的类型，id默认是用方法名作为id。
    @Bean("student")
    public student getStudent(){
        return new student("lisi",20);
    }

}
