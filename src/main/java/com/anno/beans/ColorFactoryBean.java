package com.anno.beans;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean{

    /**
     * 获取组件对象，会被添加到IOC容器中
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        return new red();
    }

    /**
     * 得到对象的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {

        return red.class;
    }

    /**
     * 设置是否为单例
     * 返回true 是单例，反之
     * @return
     */
    @Override
    public boolean isSingleton() {

        return false;
    }
}
