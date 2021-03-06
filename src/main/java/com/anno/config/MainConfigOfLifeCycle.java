package com.anno.config;

import com.anno.beans.car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean的生命周期：
 *       创建 ---> 初始化化 ----> 销毁的过程
 * 容器管理bean的生命周期
 * 我们可以 自定义初始化和销毁方法。
 *
 * 创建对象：
 *
 *      单实例：容器初始化的时候就创建了对象
 *      @Scope("prototype")
 *      多实例：没错请求对象的时候就创建一个新的对象。
 *
 *postProcessBeforeInitialization
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法。。。
 *postProcessAfterInitialization
 *
 * 销毁：
 *      单实例：容器关闭的时候
 *      多实例：容器不会管理这种bean的销毁
 *
 * 1.指定初始化和销毁方法
 *      指定init-method和destroy-method
 *
 * 2.通过让bean实现InitializingBean(定义初始化逻辑)
 *                DisposableBean(定义销毁逻辑)
 *
 * 3.可以使用JSR250
 *      @PostConstruct: 在bean创建完成并且属性赋值完成后。来执行初始化方法
 *      @ProDestroy： 在容器销毁Bean之前通知我们进行清理工作
 *
 * 4.BeanPostProcessor [interface] 、Bean的后置处理器
 *      在bean初始化前后进行一些处理工作：
 *      postProcessBeforeInitialization ： 在初始化之前工作
 *      postProcessAfterInitialization ： 在初始化之后工作
 *
 *   BeanPostProcessor的原理：
 *      populateBean(beanName, mbd, instanceWrapper);//给对象属性赋值，在初始化之前
 * {
 *      1.遍历得到容器中所有的BeanPostProcessor，
 *      2.然后挨个执行 postProcessBeforeInitialization(result, beanName);
 *      3.若迭代无下一个，直接返回result，也就是对象。
 *      applyBeanPostProcessorsBeforeInitialization(bean, beanName);//初始化之前
 *      invokeInitMethods(beanName, wrappedBean, mbd);//执行初始化
 *      applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);//初始化化之后
 * }
 *
 * Spring 对 BeanPostProcessor的底层实现
 *      BeanPostProcessor 在其中做了很多的事情。
 *      列举一些：
 *          1. ApplicationContextAwareProcessor
 *              为组件注入IOC容器。
 *          2.BeanValidationPostProcessor
 *              数据校验（？）
 *          3.InitDestroyAnnotationBeanPostProcessor
 *              setInitAnnotationType 实现 javax.annotation.PostConstruct 即@PostConstruct
 *              setDestroyAnnotationType 实现 javax.annotation.PreDestroy 即@PreDestroy
 *          4.AutowiredAnnotationBeanPostProcessor
 *              对@Autowired注解的支持
 *          还有许多功能的实现，待发掘
 */

@ComponentScan(value = "com.anno.beans")
@ComponentScan(value = "com.anno.config")
@Configuration
public class MainConfigOfLifeCycle {

    //@Scope("prototype")
    @Bean(value = "car",initMethod = "init",destroyMethod = "detory")
    public car getCar(){
        return new car();
    }
}
