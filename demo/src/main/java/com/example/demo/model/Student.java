package com.example.demo.model;
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

  
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
	//mark class as an Entity   
	@Entity  
	//defining class name as Table name  
	@Table 
	
public class Student {
   
	//mark id as primary key  
	@Id  
	//defining id as column name  
	@Column  
	private int id;  
	//defining name as column name  
	@Column  
	private String name;  
	//defining age as column name  
	@Column  
	private int age;  
	//defining email as column name  
	@Column  
	private String email;  
	
//	
//	public Student(int id, String name, int age, String email) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.age = age;
//		this.email = email;
//	}
//	public int getId()   
//	{  
//	return id;  
//	}  
//	public void setId(int id)   
//	{  
//	this.id = id;  
//	}  
//	public String getName()   
//	{  
//	return name;  
//	}  
//	public void setName(String name)   
//	{  
//	this.name = name;  
//	}  
//	public int getAge()   
//	{  
//	return age;  
//	}  
//	public void setAge(int age)   
//	{  
//	this.age = age;  
//	}  
//	public String getEmail()   
//	{  
//	return email;  
//	}  
//	public void setEmail(String email)   
//	{  
//	this.email = email;  
//	}  
	}  


