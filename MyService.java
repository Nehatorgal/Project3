package com.ttl.springboot1.SpringBootFullStackApplication1.service;

import java.util.List;
import java.util.Optional;
import com.ttl.springboot1.SpringBootFullStackApplication1.model.Student;
public interface MyService {
	public List<Student> getStudents();
public Optional<Student> getStudentById(int empid);
public Student addNewStudent(Student emp);
public Student updateStudent(Student emp);
public void deleteStudentById(int empid);
public void deleteAllstudents();
void deleteAllStudents();
}