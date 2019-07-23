package com.anno.controller;

import com.anno.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class studentControll {

    @Autowired
    private studentService studentService;
}
