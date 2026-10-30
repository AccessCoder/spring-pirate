package org.example.springpirate.service;

import org.example.springpirate.model.Student;
import org.example.springpirate.model.StudentDto;
import org.example.springpirate.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    public List<Student> findAllByAgeGreaterThan(int age) {
        return repo.findAllByAgeGreaterThan(age);
    }

    public Student createStudent(StudentDto newStudent) {
        Student student = Student.builder()
                .id(UUID.randomUUID().toString())
                .name(newStudent.name())
                .age(newStudent.age())
                .build();
       repo.save(student);

       return student;
    }

    public Student updateStudent(String id, StudentDto updatedStudent) {
        if (repo.existsById(id)) {
            Student student = Student.builder()
                    .id(UUID.randomUUID().toString())
                    .name(updatedStudent.name())
                    .age(updatedStudent.age())
                    .build();
            repo.save(student);
            return student;
        }
        throw new RuntimeException("Student not found");
    }

    public void deleteById(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
        throw new RuntimeException("Student not found");
    }
}
