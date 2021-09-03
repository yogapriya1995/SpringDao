package com.example.demo.controller;
import java.util.List;

//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;  
import com.example.demo.service.StudentService;
//import com.sun.org.slf4j.internal.Logger;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.apache.commons.logging.Log;
import org.slf4j.MDC;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
//import lombok.extern.slf4j.Slf4j;

 
//@Log4j2
@Slf4j
@RestController
@RequestMapping("/stu")
public class StudentController {
	//creating RestController
	@Autowired
	private StudentService studentService ;  
	
	//autowired the StudentService class  
	//@Autowired
	//public StudentController(StudentService studentService) {
	//	this.studentService = studentService;
	//}
	//creating a get mapping that retrieves all the students detail from the database   

//	@GetMapping("/getmicro2")
//	@HystrixCommand(fallbackMethod = "getMicro2InstanceFallback")
//    public String getMicro2Instance()
//    {
//        String url = "http://localhost:8081/microservice2/port";
//        System.out.println("inside normal method");
//   	 
//        String response = new RestTemplate().getForObject(url,  
//                          String.class);
//        return response;
//    }
	@GetMapping("/student")  
	private List<Student> getAllStudent()   
	{  
		log.info("Getting all the Student Details");
		//log.debug("Debug Message");
		//List<Student> s=studentService.getAllStudent()
		  
	return studentService.getAllStudent();  
	}  
//    public  String getMicro2InstanceFallback()
//    {
//    	 System.out.println("inside fallback method");
//    	 log.info("Inside fallback");
// 		   
//        return "Microservice2 is down!!";
//       }
//	//creating a get mapping that retrieves the detail of a specific student  
	@GetMapping("/student/{id}")  
	private ResponseEntity<Object> getStudent(@PathVariable("id") int id)   
	{  
		try {
			studentService.getStudentById(id);
			log.info("getting students by ID"+id);
			return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);  
			
		}catch(Exception e) {
			throw new StudentNotFoundException();
		}
	}  
	//creating a delete mapping that deletes a specific student  
	@DeleteMapping("/student/{id}")  
	private ResponseEntity<Object> deleteStudent(@PathVariable("id") int id)   
	{  
	studentService.delete(id); 
	return new ResponseEntity<>("Product with the ID "+id+ " delected successfully",HttpStatus.OK);
	}  
	//creating post mapping that post the student detail in the database  
	@PostMapping("/student")  
	private int saveStudent(@RequestBody Student student)   
	{  
	//studentService= new StudentService();
	studentService.saveOrUpdate(student);  
	return student.getId();  
	}  
	}  


