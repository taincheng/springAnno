package com.anno.config;

import com.anno.controller.MyBeanPostProcessor;
import com.anno.dao.studentDao;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * 自动装配；
 *     Spring 利用依赖注入（DI），完成对IOC容器的各个组件的依赖关系赋值。
 *
 * 1.@Autowired,自动注入
 *      1.默认优先按照类型去容器中查找对应的组件。
 *      2.如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找。
 *      studentService{
 *          @Autowired
 *          student bookDao
 *      }
 *      3.@Qualifier(""),使用这个注解可以指定需要装配的组件的id，而不是使用属性名
 *      4.自动装配默认一定要将属性赋值好，没有就会报错
 *          可以使用@Autowired(required=false);
 *      5.@Primary: 让Spring进行自动装配的时候，默认使用首选的bean。
 *          也可以继续指定@Qualifier,这里只是指定自动装配，不是指getBean里面的
 * 2.Spring 还支持使用@Resource(JSR250)和@Inject(JSR330)[java 规范的注解]
 *      @Resource：
 *          可以和@Autowired一样实现自动装配。默认属性名装配，可设置名字
 *          没有能支持@Primary功能，没有支持和@Autowired(required = false)一样的功能
 *      @Inject:
 *          需要导入javax.inject的依赖包。和Autowired一样，但是也没有required的控制功能。
 *
 * 3.@Autowired: 构造器，参数，方法，属性 ：都是从IOC容器中获取参数组件的值
 *      1.标注在方法位置，@Bean + 方法参数：参数从容器中获取。默认可以不写，一样的效果。
 *      2.标注在构造器上：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略
 *      3.放在参数位置。
 *4.自定义组件想要使用Spring容器底层的一些组件，（ApplicationContext，BeanFactory，等）
 *      自定义组件实现xxxAware，便有实现的方法来注入对应的组件:
 *          在创建对象的时候会调用接口的方法注入相关组件：那些接口都实现了Aware接口；
 *      把Spring底层 的一些组件注入到自定义的Bean中：
 *          XXXAware：功能的实现都是在xxxProcessor中。
 *
 */
@Configuration
//@ComponentScan(value = {"com.anno.controller","com.anno.dao","com.anno.service"})

@ComponentScan(value = "com.anno.dao")
@ComponentScan(value = "com.anno.service")
@ComponentScan(value = "com.anno.controller")
@ComponentScan(value = "com.anno.beans")
public class MainConfigOfAutowired {

    @Primary
    @Bean(value = "studentDao2")
    public studentDao studentDao(){
        studentDao studentDao2 = new studentDao();
        studentDao2.setLabel1("2");
        return studentDao2;
    }
}
