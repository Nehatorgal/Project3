package com.ttl.springboot1.SpringBootFullStackApplication1.service;

import java.util.List;
import java.util.Optional;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ttl.springboot1.SpringBootFullStackApplication1.model.Student;
import com.ttl.springboot1.SpringBootFullStackApplication1.repository.StudentRepository;
@Service
public class MyServiceImpl implements MyService { 
	@Autowired
StudentRepository dao; @Override
public List<Student> getStudents() {
// TODO Auto-generated method stub
return dao.findAll(); // select all
} @Override
public Optional<Student> getStudentById(int empid) {
// TODO Auto-generated method stub
return dao.findById(empid); // select one record based on id
} @Override
public Student addNewStudent(Student emp) {
// TODO Auto-generated method stub
return dao.save(emp);
} @Override
public Student updateStudent(Student emp) {
// TODO Auto-generated method stub
return dao.save(emp);
} @Override
public void deleteStudentById(int empid) {
// TODO Auto-generated method stub
dao.deleteById(empid);
} @Override
public void deleteAllStudents() {
dao.deleteAll(); 
}
@Override
public void deleteAllstudents() {
	// TODO Auto-generated method stub
	
}
}

