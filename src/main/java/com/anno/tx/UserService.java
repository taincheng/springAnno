package com.anno.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public void insertUser(){
        userDao.insert();
        System.out.println("insert into ok");
    }
}
