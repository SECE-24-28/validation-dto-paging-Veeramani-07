package com.example.SpringSecurity.controller;

import com.example.SpringSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    List<Student> l=new ArrayList<>(
            Arrays.asList(new Student(1,"jeni","cse"),
                    new Student(2,"hari","it"))
    );
    @GetMapping("students")
    public List<Student> getAllStudents(){
        return l;
    }

    @PostMapping("students/add")
    public List<Student> addStudent(@RequestBody Student std){
        l.add(std);
        return l;
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
