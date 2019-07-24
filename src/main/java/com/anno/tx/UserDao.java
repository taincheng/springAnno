package com.anno.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //事务管理，出错回滚
    @Transactional
    public void insert(){
        String sql = "INSERT into category_ values(null,?)";
        String name = UUID.randomUUID().toString().substring(0,5);
        jdbcTemplate.update(sql,name);
        //int i = 9/0;
    }
}
