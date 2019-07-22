package com.anno.config;

import com.anno.beans.blue;
import com.anno.beans.red;
import com.anno.beans.student;
import com.anno.condition.LinusCondition;
import com.anno.condition.MyImportBeanDefinitionRegistrar;
import com.anno.condition.MyImportSeletor;
import com.anno.condition.WindowsCondition;
import org.springframework.context.annotation.*;

//@Conditional(WindowsCondition.class)  //只有满足该条件，该类的所有bean才能被创建。
@Configuration
@Import({red.class, blue.class, MyImportSeletor.class, MyImportBeanDefinitionRegistrar.class})
public class Mainconfig2 {

    //默认是单实例
    /*
    prototype : 多实例，没次获取都调用方法创建一个新的对象
    singleton : 默认的模式，单实例, IOC启动时会预加载，先创建好对象。
    request : 同一个请求创建一个实例
    session : 同一个session创建一个实例

    懒加载：
          单实例bean：默认在容器启动的时候创建对象，（饿汉模式）
          懒加载：容器启动不创建对象，第一次使用（获取）Bean创建对象，并初始化（饱汉模式）
     */
    @Scope("prototype")
    //@Lazy
    @Bean(value = "student")
    public student getStudent(){
        return new student("zhang3",29);
    }

    /**
     * @Conditional : 按照一定的条件进行判断，满足条件给容器注册bean
     *
     * 通过自定义的Conditional来对需要加载的Bean进行判断。
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public student Student01(){
        return new student("Bill Gates ",62);
    }

    @Conditional(LinusCondition.class)
    @Bean("linus")
    public student student02(){
        return new student("linus",53);
    }

    /**
     * 给容器注册组件
     * 1.包扫描  + 组件标注注解(@Controller/@Service/@Repository/@Component)[局限于自己创建的类]
     * 2.@Bean[导入的第三方包里面的组件]
     * 3.@Import[快速给容器中导入一个组件]
     *       1.@Import(要导入到容器中的组件)：容器中就会自动注册这个组件，id默认是全类名。
     *       2.ImportSelector:返回需要导入的组件的全类名数组。
     *       3.ImportBeanDefinitionRegistrar:手动注册bean到容器中
     */
}
