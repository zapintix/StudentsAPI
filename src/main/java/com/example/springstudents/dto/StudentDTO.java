package com.example.springstudents.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO {
    private String firstName;
    private String lastName;
    private LocalDate dataOfBirth;
    private String email;
    private Long group;
}
