package com.anno.service;

import com.anno.dao.studentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class studentService {

    //指定创建的对象，如果没有这个组件，那就报错
    //可以在@Autowired里面设置required=false。来设置不是必须装载组件
    @Qualifier("studentDao")
    @Autowired
    private studentDao studentDao;

    public void print(){
        System.out.println(studentDao);
    }

    @Override
    public String toString() {
        return "studentService{" +
                "studentDao=" + studentDao +
                '}';
    }
}
