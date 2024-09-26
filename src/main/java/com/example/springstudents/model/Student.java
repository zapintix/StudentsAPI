package com.example.springstudents.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dataOfBirth;
    @Column(unique = true)
    private String email;
    @Transient
    private int age;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public int getAge() {
        return Period.between(dataOfBirth, LocalDate.now()).getYears();
    }

    public String getGroup() {
        return group != null ? group.getName():null;
    }

}

