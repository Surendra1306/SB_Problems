package com.surendra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surendra.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
