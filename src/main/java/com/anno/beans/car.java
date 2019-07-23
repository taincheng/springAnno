package com.anno.beans;

import org.springframework.stereotype.Component;

@Component
public class car {
    public car(){
        System.out.println("car had created");
    }

    public void init(){
        System.out.println("init ....");
    }

    public void detory(){
        System.out.println("detory.....");
    }
}
