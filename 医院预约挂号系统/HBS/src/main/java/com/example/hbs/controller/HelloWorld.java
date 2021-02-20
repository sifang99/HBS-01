package com.example.hbs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping("/hello")
    public String HelloWorld(){
        return "Hello World!";
    }
}
