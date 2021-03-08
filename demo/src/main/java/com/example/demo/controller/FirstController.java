package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    
    @GetMapping
    public String getSomething() {
        return "hello world";
    }

}
