package com.anno.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * Profile:
 *      Spring 为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能。
 *
 * 开发环境、测试环境、生产环境
 * 数据源：（/A）,(/B),(/C),
 * Spring提供的该功能可以帮助我们不需要修改太多代码就可以相对当前环境来
 *          改变数据源。
 *
 * @Profile: 指定组件在哪个环境的情况下才能被注册到容器中，
 *           如果不指定，任何环境下都能注册这个指令
 *     1.加了环境标识的Bean，只有这个环境被激活的时候才能注册到容器中，
 *          默认是default环境。
 *     2.如果设置在类上，只有的指定环境，该类才可以生效。
 *
 *     3.没有标注的Bean是任何环境都是可以生效的
 */

@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware{

    @Value("${db.User}")
    private String User;

    private String driverClass;

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(User);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("Dev")
    @Bean("DevDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(User);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/shiro");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("Prod")
    @Bean("ProdDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(User);
        dataSource.setPassword("admin");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/cart");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.driverClass = resolver.resolveStringValue("${db.driverClass}");
    }
}
