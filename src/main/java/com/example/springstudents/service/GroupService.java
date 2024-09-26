package com.example.springstudents.service;

import com.example.springstudents.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAllGroups();
    Group saveGroup(Group group);
    Group findGroupById(Long id);
    Group updateGroup(Long id, Group group);
    boolean deleteGroup(Long id);
}
