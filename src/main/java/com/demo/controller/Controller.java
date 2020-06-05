package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.demo.model.Student;

import com.demo.repository.StudentRepository;
import com.demo.service.StudentService;

@RestController
@CrossOrigin("*")
public class Controller {

	@Autowired
	public StudentRepository studentRepository;

	@Autowired
	public StudentService studentService;

	@GetMapping("/student")
	List<Student> listStudent() {


		List<Student> students = studentService.studentList();

		return students;

	}

	@PostMapping("student") 
	boolean createStudent(@RequestBody Student student){
		
		boolean result = studentService.studentCreate(student);
		return result;
		
	}
	
	@DeleteMapping("/student/{studentID}")
	boolean deleteStudent(@PathVariable("studentID") int studentID) {
		
		boolean result = studentService.delete(studentID);
		return result;
		
	}
	
	@PutMapping("/student/{studentID}")
	boolean updateData(@PathVariable("studentID") int studentID, @RequestBody Student student) {
		
		boolean result = studentService.UpdateData(student, studentID);
		return result;
		
	}
	

}
