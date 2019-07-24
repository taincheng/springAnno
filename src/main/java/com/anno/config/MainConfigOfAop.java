package com.anno.config;

import com.anno.aop.LogAspects;
import com.anno.aop.MathCalculator;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP:[动态代理]
 *      指在程序运行期间动态的将某段代码切入到指定方法
 *        指定位置进行运行的编程方式。
 *
 * 1.导入aop模块：Spring AOP(spring-aspects)
 * 2.定义一个业务逻辑类，在业务逻辑运行的时候将日志进行打印（方法之前，方法运行后，方法出错等）
 * 3.定义一个日志切面类，切面类里面的方法需要动态感知业务逻辑的某种方法的运行情况
 *      通知方法：
 *              前置通知(@Before)：方法运行之前
 *              后置通知(@After): 方法运行之后(无论方法是异常还是正常)
 *              返回通知(@AfterReturning)： 方法正常执行返回之后
 *              异常通知(@AfterThrowing)： 方法异常执行，记录异常信息
 *              环绕通知(@Around)： 动态代理，手动推进目标方法进行（JoinPoint.procced()）
 * 4.给切面类的目标方法标注何时何地运行（通知注解）
 * 5.将切面类和业务逻辑类（目标方法所在类）都加入到容器中
 * 6.必须告诉Spring，谁是切面类（给切面类加一个注解@Aspect）
 * 7.给配置类中加@EnableAspectJAutoProxy [开启基于注解的aop模式]
 *      在Spring中很多的@EnableXXX,作用都是开启某项功能。
 *
 *
 *  三步：
 *      1.将业务逻辑组件和切面类都加入到容器中；告诉Spring哪个是切面类（@Aspect）
 *      2.在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 *      3.开启基于注解的AOP模式。
 *
 *  AOP原理：【看给容器中注册了什么组件，这个组件什么时候工作，这个组件的功能是什么？】
 *         @EnableAspectJAutoProxy：
 *  1、@EnableAspectJAutoProxy 是什么？
 *          @Import(AspectJAutoProxyRegistrar.class) ，给容器导入AspectJAutoProxyRegistrar
 *              利用AspectJAutoProxyRegistrar自定义给容器中注册bean：
 *          internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
 *        给容器中注册一个AnnotationAwareAspectJAutoProxyCreator；
 *
 *  2.AnnotationAwareAspectJAutoProxyCreator：功能是什么？
 *          继承自 -> AspectJAwareAdvisorAutoProxyCreator
 *                  -> AbstractAdvisorAutoProxyCreator
 *                    -> AbstractAutoProxyCreator
 *                          implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *                      管理后置处理器（在bean初始化完成前后做事情）、自动装配BeanFactory
 *      AbstractAutoProxyCreator.setBeanFactory()
 *      AbstractAutoProxyCreator.有后置处理器的逻辑
 *
 *      AbstractAdvisorAutoProxyCreator 重写了 setBeanFactory
 *      AbstractAdvisorAutoProxyCreator.initBeanFactory()
 *
 *      AnnotationAwareAspectJAutoProxyCreator.initBeanFactory
 *
 *    ==流程==
 *      1.传入配置类，创建IOC容器
 *      2.注册配置类，调用refresh() 刷新容器；
 *      3.registerBeanPostProcessors(beanFactory);注册bean的后置处理器来方便拦截bean的创建。
 *              1.先获取IOC容器已经定义了的需要创建对象的所有BeanPostProcessor
 *              2.给容器中加别的BeanPostProcessor
 *              3.优先注册实现了PriorityOrdered接口的BeanPostProcessors。
 *              4.在给容器中注册实现了Ordered接口的BeanPostProcessor。
 *              5.注册没实现优先级接口的BeanPostProcessors；
 *              6.注册BeanPostProcessors，实际上就是创建BeanPostProcessors对象，保存在容器中。
 *
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAop {

    //将业务逻辑加入容器中
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }

    //将切面类加入到容器中
    @Bean
    public LogAspects aspects(){
        return new LogAspects();
    }
}
