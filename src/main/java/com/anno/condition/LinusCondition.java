package com.anno.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinusCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //是否是Linus系统

        //获取环境
        Environment environment = conditionContext.getEnvironment();

        //获取当前系统的环境
        String property = environment.getProperty("os.name");
        if (property.contains("Linus")) {
            return true;
        }
        return false;
    }
}
