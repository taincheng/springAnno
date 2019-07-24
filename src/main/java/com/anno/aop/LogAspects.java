package com.anno.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//告诉spring，当前类是一个切面类
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1.本类引用 直接写方法名
    //2.其他的切面引用 写方法的全类名
    @Pointcut("execution(public int com.anno.aop.MathCalculator.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() +
                "  start.. " + Arrays.asList(args));
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() +
                " End.. " + Arrays.asList(joinPoint.getArgs()));
    }

    //Joinpoint一定出现在参数列表的第一位
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result){
        System.out.println(joinPoint.getSignature().getName() +
                " Return.. " + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex){
        System.out.println(joinPoint.getSignature().getName() +
                " Exception.. " + ex);
    }
}
