package com.zoloo.schedulertask.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.zoloo.schedulertask.model.Student;
import com.zoloo.schedulertask.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    private void init(){
        
    }
    
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getStudents(){
        List<Student> lstStudents = new ArrayList<>();
        studentRepository.findAll().iterator().forEachRemaining(lstStudents::add);
        return lstStudents;
    }
}