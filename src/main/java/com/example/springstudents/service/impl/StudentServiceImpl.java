package com.example.springstudents.service.impl;

import com.example.springstudents.model.Student;
import com.example.springstudents.repository.GroupRepository;
import com.example.springstudents.repository.StudentRepository;
import com.example.springstudents.service.GroupService;
import com.example.springstudents.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Primary
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    @Override
    public List<Student> findAllStudent() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);


    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Student updateStudent(String email, Student student) {
        Student existingStudent = repository.findByEmail(email);
        if (existingStudent != null){
            if(student.getFirstName() != null){
                existingStudent.setFirstName(student.getFirstName());
            }
            if(student.getLastName() != null){
                existingStudent.setLastName(student.getLastName());
            }
            if(student.getDataOfBirth() != null){
                existingStudent.setDataOfBirth(student.getDataOfBirth());
            }

            return repository.save(existingStudent);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean deleteStudent(String email) {
        Student existingStudent = repository.findByEmail(email);
        if(existingStudent !=null){
            repository.deleteByEmail(email);
            return true;
        }
        return false;
    }
}
