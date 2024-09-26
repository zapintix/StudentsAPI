package com.example.springstudents.service.impl;

import com.example.springstudents.model.Group;
import com.example.springstudents.repository.GroupRepository;
import com.example.springstudents.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository repository;
    @Override
    public List<Group> findAllGroups() {
        return repository.findAll();
    }

    @Override
    public Group saveGroup(Group group) {
        return repository.save(group);
    }

    @Override
    public Group findGroupById(Long id) {
        return repository.findGroupById(id);
    }

    @Override
    public Group updateGroup(Long id, Group group) {
        Group updatedGroup = repository.findGroupById(id);
        if(updatedGroup != null){
            if(group.getName()!= null){
                updatedGroup.setName(group.getName());
            }
            repository.save(updatedGroup);
        }
        return null;
    }

    @Override
    public boolean deleteGroup(Long id) {
        Group deletedGroup = repository.findGroupById(id);
        if(deletedGroup != null){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
