package com.example.SpringSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String greet(){
        return "hi guys";
    }

    @GetMapping("/")
    public String home(HttpServletRequest request){
        return "Welcome to Spring Security"+request.getSession().getId();
    }
}
