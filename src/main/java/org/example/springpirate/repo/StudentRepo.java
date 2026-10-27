package org.example.springpirate.repo;

import org.example.springpirate.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

    List<Student> findAllByAgeGreaterThan(int age);
}
