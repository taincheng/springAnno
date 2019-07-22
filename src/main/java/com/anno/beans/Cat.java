package com.anno.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component(value = "cat")
public class Cat implements InitializingBean,DisposableBean{
    public Cat(){
        System.out.println("Cat .... had Created");
    }

    /**
     * 在对象被销毁后调用
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("Cat  destory ... ");
    }

    /**
     * 在对象创建好了之后，属性初始化好了之后，调用
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat  init ... ");
    }
}
