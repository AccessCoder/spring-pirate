package org.example.springpirate.controller;

import org.example.springpirate.model.Student;
import org.example.springpirate.model.StudentDto;
import org.example.springpirate.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService service;

    //Dependency Injection -> Constructor Injection
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudent();
    }

    @GetMapping("/search")
    public List<Student> findAllStudentsAgeGreaterThan(int age){
        return service.findAllByAgeGreaterThan(age);
    }

    @PostMapping
    public Student addStudent(@RequestBody StudentDto newStudent){
        return service.createStudent(newStudent);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id,
                                 @RequestBody StudentDto updatedStudent){
        return service.updateStudent(id, updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id){
        service.deleteById(id);
    }



}
