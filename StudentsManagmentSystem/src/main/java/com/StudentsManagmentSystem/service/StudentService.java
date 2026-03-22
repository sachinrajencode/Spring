package com.StudentsManagmentSystem.service;

import java.util.List;

import com.StudentsManagmentSystem.entity.Student;

public interface StudentService {

	public List<Student> getAllStudent();
	
	public Student saveStudent(Student student);
	
	public Student getById(int id);
	
	public void deleteById(int id);
	
}
