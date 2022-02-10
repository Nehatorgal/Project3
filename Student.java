package com.ttl.springboot1.SpringBootFullStackApplication1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
//import org.hibernate.annotations.DynamicInsert;
import org.hibernate.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;//spring data jpa jars
@Component@Entity
@Table(name = "students")@DynamicInsert
@DynamicUpdate
public class Student { @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String department;
private String email; public Student() {
} public int getId() {
return id;
} public void setId(int id) {
this.id = id;
} public String getName() {
return name;
} public void setName(String name) {
this.name = name;
} public String getDepartment() {
return department;
} public void setDepartment(String department) {
this.department = department;
} public String getEmail() {
return email;

}
 public void setEmail(String email) {
this.email = email;
} @Override
public String toString() {
return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", email=" + email + "]";
}


}


