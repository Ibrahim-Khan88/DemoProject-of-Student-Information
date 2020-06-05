package com.demo.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	
	Student findByStudentID(int studentId);
	
	@Query("select s from Student s")
	List<Student> StudentList();
	
	@Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Student u set u.name = ?1 , u.email = ?2 , u.phoneNumber = ?3 , u.age = ?4 where u.studentID = ?5")
    int updateStudent(String name, String email, String phoneNumber, int age, int studentID);
	
	//

}
