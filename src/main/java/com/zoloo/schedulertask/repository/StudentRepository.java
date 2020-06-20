package com.zoloo.schedulertask.repository;

import com.zoloo.schedulertask.model.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    
}