package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Student;
import com.demo.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public boolean studentCreate(Student student){
		
		Student s = studentRepository.save(student);
		if(s != null)
			return true;
		
		return false;
		
	}
	
	public boolean UpdateData(Student student, int id) {
		Student s = studentRepository.findByStudentID(id);
		if(s != null) {			
			int result = studentRepository.updateStudent(student.getName(), student.getEmail(), student.getPhoneNumber(),
					student.getAge(), id);
			
		    if(result == 1) 
		    	return true;
			return false;
		}
		
		return false;  
	}
	
	public List<Student> studentList(){
		return studentRepository.StudentList();
	}
	
	public boolean delete(int id) {
		
		Student s = studentRepository.findByStudentID(id);
		if(s != null) {			
			studentRepository.deleteById(id);
			return true;
		}
		
		return false;
		
	}

}
