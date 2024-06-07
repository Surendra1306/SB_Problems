package com.surendra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.surendra.entity.Student;
import com.surendra.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository repository;

	@Override
	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student getStudentById(long id) {
		return repository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public void deleteStudentById(long id) {
		repository.deleteById(id);
	}
	
	

}
