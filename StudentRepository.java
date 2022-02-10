package com.ttl.springboot1.SpringBootFullStackApplication1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttl.springboot1.SpringBootFullStackApplication1.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
