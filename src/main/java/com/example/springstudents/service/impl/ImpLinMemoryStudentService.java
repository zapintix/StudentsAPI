package com.example.springstudents.service.impl;

import com.example.springstudents.model.Student;
import com.example.springstudents.repository.InMemoryStudentDAO;
import com.example.springstudents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImpLinMemoryStudentService implements StudentService {
    private final InMemoryStudentDAO repository;
    @Override
    public List<Student> findAllStudent(){
        return repository.findAllStudent();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Student updateStudent(String email, Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(String email) {
        repository.deleteStudent(email);
        return false;
    }
}
