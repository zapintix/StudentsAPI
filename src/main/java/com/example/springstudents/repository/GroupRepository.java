package com.example.springstudents.repository;

import com.example.springstudents.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findGroupById(Long id);
    void deleteById(Long id);
}
