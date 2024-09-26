package com.example.springstudents.service;

import com.example.springstudents.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    Student saveStudent (Student student);
    Student findByEmail(String email);
    Student updateStudent(String email, Student student);
    boolean deleteStudent(String email);


}
