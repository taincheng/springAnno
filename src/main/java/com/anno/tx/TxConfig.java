package com.anno.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 声明式事务
 *
 * 环境搭建：
 *     1.导入相关依赖
 *          数据源、数据库驱动、Spring-jdbc模块
 *     2.配置数据源、JDBCTemplate（Spring提供的简化数据库操作的工具）操作数据
 *     3.给方法上标注@Transactional，表示当前方法是一个事务方法
 *     4.@EnableTransactionManagement， 开启基于注解的事务管理功能
 *     5.配置事务管理器来控制事务；
 *          @Bean
            public PlatformTransactionManager transactionManager() throws PropertyVetoException {
                return new DataSourceTransactionManager(dataSource());
            }
 *
 */

//开启事务管理功能
@EnableTransactionManagement
@ComponentScan(value = "com.anno.tx")
@Configuration
public class TxConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("admin");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //Spring对@Configuration类会特殊处理：
        //    给容器中加组件的方法，多次调用都只是从容器中找组件。
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //注册事务管理器在容器中
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
