package com.example.demo.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;  


public interface StudentRepository extends CrudRepository<Student, Integer> {

}
