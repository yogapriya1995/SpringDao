package com.example.demo.service;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;  

@Component
public class StudentService {
//	package com.javatpoint.service;  
	  

	@Autowired  
	StudentRepository studentRepository;  
	//getting all student records  
	public List<Student> getAllStudent()   
	{  
	List<Student> students = new ArrayList<Student>();  
	studentRepository.findAll().forEach(student -> students.add(student));  
	return students;  
	}  
	//getting a specific record  
	public Student getStudentById(int id) throws Exception  
	{ 
		
			
			Student s=studentRepository.findById(id).get();
			return s;
			
		
		
	//return studentRepository.findById(id).get();  
	}  
	public void saveOrUpdate(Student student)   
	{  
	studentRepository.save(student);  
	}  
	//deleting a specific record  
	public void delete(int id)   
	{  
	studentRepository.deleteById(id);  
	}  
	}  


