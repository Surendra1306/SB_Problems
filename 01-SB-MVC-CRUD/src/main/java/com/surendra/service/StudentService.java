package com.surendra.service;

import java.util.List;

import com.surendra.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(long id);
	
	Student updateStudent(Student Student);
	
	void deleteStudentById(long id);

}
