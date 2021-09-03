package com.example.demo;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.model.Student;

@ExtendWith(MockitoExtension.class)
@DataJpaTest

class alculator {

	//@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//
	@Test
	void test() {
		assertTrue(true);
	}
	 @Autowired
	    private StudentRepository repository;

	    @BeforeEach
	    void initUseCase() {
	    	
	        List<Student> students = Arrays.asList(
	                new  Student(007,"ganapathy",78,"ganapathy@gmail.com")
	        );
	        repository.saveAll(students);
	    }

	    @AfterEach
	    public void destroyAll(){
	    	repository.deleteAll();
	    	
	    }

	    @SuppressWarnings("deprecation")
		@Test
	    void saveAll_success() {
	    	List<Student> students = Arrays.asList(
	                new  Student(007,"ganapathy",78,"ganapathy@gmail.com"),
	                new  Student(8,"gomathy",18,"gomathy@gmail.com"),
	                new  Student(9,"siranjeevi",28,"siranjeevi@gmail.com")
	                
	                
	        );      
	        Iterable<Student> allCustomer = repository.saveAll(students);

	        AtomicInteger validIdFound = new AtomicInteger();
	        allCustomer.forEach(student -> {
	            if(student.getId()>0){
	                validIdFound.getAndIncrement();
	            }
	        });

	        assertThat(validIdFound.intValue()).isEqualTo(3);
	    }

	    @SuppressWarnings("deprecation")
		@Test
	    void findAll_success() {
	        List<Student> allCustomer = (List<Student>) repository.findAll();
	        assertThat(allCustomer.size()).isGreaterThanOrEqualTo(1);
	    }


}
