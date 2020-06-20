package com.zoloo.schedulertask.controller;

import java.util.List;

import com.zoloo.schedulertask.model.Student;
import com.zoloo.schedulertask.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("student")
public class StudentController {
    
    @Autowired
    StudentService studentService;

    @PostMapping(value="/add")
    public Student addStudent(@RequestBody Student entity) {
        //TODO: process POST request
        return studentService.addStudent(entity);
    }
    
    @GetMapping(value="/all")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    
}