package com.StudentsManagmentSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentsManagmentSystem.entity.Student;
import com.StudentsManagmentSystem.repository.Studentrepository;
import com.StudentsManagmentSystem.service.StudentService;

@Service
public class ServiceImpl implements StudentService{
	
	/* example of injection */
	@Autowired
	com.StudentsManagmentSystem.repository.Studentrepository Studentrepository;
    
	@Override
	public List<Student> getAllStudent() {
		
		List<Student> list =Studentrepository.findAll();
		
		return list;
	}

	@Override
	public Student saveStudent(Student student) {
		
		return Studentrepository.save(student);
	}

	@Override
	public Student getById(int id) {
		
		return Studentrepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		
		Studentrepository.deleteById(id);
	}

}
