package com.anno.condition;

import com.anno.beans.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registryegistry) {

        //判断容器中是否包含两种类的定义
        boolean b1 = registryegistry.containsBeanDefinition("com.anno.beans.blue");
        boolean b2 = registryegistry.containsBeanDefinition("com.anno.beans.black");

        if (b1 && b2){
            BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            registryegistry.registerBeanDefinition("rainbow",beanDefinition);
        }
    }
}
