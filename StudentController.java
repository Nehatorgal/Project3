package com.ttl.springboot1.SpringBootFullStackApplication1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ttl.springboot1.SpringBootFullStackApplication1.model.Student;
import com.ttl.springboot1.SpringBootFullStackApplication1.service.MyService;
 
@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = {"GET","POST","PUT","DELETE"})
@RequestMapping("/api/v1")
public class StudentController {



@Autowired
MyService service;

@Bean
public WebMvcConfigurer corsConfigurer() {
return new WebMvcConfigurerAdapter() {
@Override
public void addCorsMappings(CorsRegistry registry) {
registry.addMapping("/**").allowedOrigins("*");
}
};
}



// localhost:8080/employee/all



@RequestMapping(value = "/student/all", method = RequestMethod.GET)
public List<Student> getEmployees() {
System.out.println(this.getClass().getSimpleName() + " getStudents() method invoked");



return service.getStudents();
}



// localhost:8080/projectname/employee/1234 ==> 1234 @PathVariable id
@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
public Student getEmployeeById(@PathVariable int id) throws Exception {
System.out.println(this.getClass().getSimpleName() + " getEmployeeById() method invoked");
Optional<Student> emp = service.getStudentById(id);



if (!emp.isPresent())
throw new Exception("could not find Employee with id " + id);



return emp.get();
}



@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
public Student createEmployee(@RequestBody Student emp) {
System.out.println(this.getClass().getSimpleName() + " createEmployee method invoked");
return service.addNewStudent(emp);
}



@RequestMapping(value = "/employee/update/{id}", method = RequestMethod.PUT)
public Student updateEmployee(@PathVariable int id, @RequestBody Student UpEmp) throws Exception {
System.out.println(this.getClass().getSimpleName() + " createEmployee method invoked");



Optional<Student> emp = service.getStudentById(id);



if (!emp.isPresent())
throw new Exception("could not find Employee with id " + id);



if (UpEmp.getName() == null || UpEmp.getName().isEmpty())
UpEmp.setName(emp.get().getName());
if (UpEmp.getDepartment() == null || UpEmp.getDepartment().isEmpty())
UpEmp.setDepartment(emp.get().getDepartment());
if (UpEmp.getEmail() == null || UpEmp.getEmail().isEmpty())
UpEmp.setEmail(emp.get().getEmail());
// for where clause
UpEmp.setId(id);



return service.updateStudent(UpEmp);



}



@RequestMapping(value = "/student/delete/{id}", method = RequestMethod.DELETE)
public void deleteEmployeeById(@PathVariable int empid) throws Exception {
System.out.println(this.getClass().getSimpleName() + " deleteEmployeeById() method invoked");
Optional<Student> emp = Optional.empty();



if (!emp.isPresent())
throw new Exception("could not find Employee with id " + empid);



service.deleteStudentById(empid);
}
}