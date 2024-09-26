package com.example.springstudents.controller;

import com.example.springstudents.dto.ApiResponse;
import com.example.springstudents.model.Group;
import com.example.springstudents.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/groups")
public class GroupController {
    private final GroupService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Group>>> findAllGroups(){
        List<Group> groups = service.findAllGroups();
        return ResponseEntity.ok(new ApiResponse<>("Список групп", groups, true));
    }

    @PostMapping("save_group")
    public ResponseEntity<ApiResponse<Group>> saveGroup(@RequestBody Group group){
        Group savedGroup = service.saveGroup(group);
        return ResponseEntity.ok(new ApiResponse<>("Группа сохранена", savedGroup, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Group>> findGroupById(@PathVariable Long id){
        Group group = service.findGroupById(id);
        if(group != null){
            return ResponseEntity.ok(new ApiResponse<>("Группа найдена", group, true));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Группа не найдена", null, false));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Group>> updateGroup(@PathVariable Long id, @RequestBody Group group){
        Group updatedGroup = service.updateGroup(id, group);
        if(updatedGroup != null){
            return ResponseEntity.ok(new ApiResponse<>("Группа успешно обновлена", group, true));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Группа не найдена", null, false));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable Long id){
        boolean isDeleted = service.deleteGroup(id);
        if(isDeleted){
            return ResponseEntity.ok("Группа успешно удалена");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Группа не найдена");
        }
    }





}
