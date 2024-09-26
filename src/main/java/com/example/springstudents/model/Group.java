package com.example.springstudents.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students;



    public int getStudents() {
        return students != null ? students.size():0;
    }

}
