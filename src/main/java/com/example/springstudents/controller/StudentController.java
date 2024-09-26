package com.example.springstudents.controller;

import com.example.springstudents.dto.ApiResponse;
import com.example.springstudents.dto.StudentDTO;
import com.example.springstudents.model.Group;
import com.example.springstudents.model.Student;
import com.example.springstudents.service.GroupService;
import com.example.springstudents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService service;
    private final GroupService groupService;

    @GetMapping
    public List<Student> findAllStudent(){
        return service.findAllStudent();

    }
    @PostMapping("save_student")
    public ResponseEntity<ApiResponse<Student>> saveStudent(@RequestBody StudentDTO studentDTO){
        Group group = groupService.findGroupById(studentDTO.getGroup());
        if(group==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Группа не найдена", null, false));
        }

        Student student = new Student();

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setDataOfBirth(studentDTO.getDataOfBirth());
        student.setEmail(studentDTO.getEmail());
        student.setGroup(group);

        Student savedStudent = service.saveStudent(student);
        return ResponseEntity.ok(new ApiResponse<>("Студент сохранён", savedStudent, true));
    }



    @GetMapping("/{email}")
    public ResponseEntity<ApiResponse<Student>> findByEmail(@PathVariable String email){
        Student student = service.findByEmail(email);
        if (student!=null){
            return ResponseEntity.ok(new ApiResponse<>("Cтудент найден", student, true));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Cтудент не найден",null, false));
        }
    }

    @PutMapping("update_student/{email}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@PathVariable String email, @RequestBody Student student){
        Student updatedStudent = service.updateStudent(email, student);
        if(updatedStudent != null){
            return ResponseEntity.ok(new ApiResponse<>("Студент успешно обновлён", updatedStudent, true));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Студент не найден", null, false));
        }
    }
    @DeleteMapping("delete_student/{email}")
    public ResponseEntity<String> deleteStudent(@PathVariable String email){
        boolean isDeleted = service.deleteStudent(email);
        if(isDeleted){
            return ResponseEntity.ok("Студент успешно удалён");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Студеент не найден");
        }
    }

}


