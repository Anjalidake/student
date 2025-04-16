package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Repository.StudentRepo;
import com.example.pojo.StudentPojo;

@RestController
public class StudentController {
	@Autowired
	StudentRepo repo;
     
	@GetMapping("/students")
	public List<StudentPojo> getAllStudents(){
		List<StudentPojo> students=repo.findAll();
		return students;
	}
	 @GetMapping("/students/{id}")
	 public StudentPojo getStudentPojo(@PathVariable int id) {
		 StudentPojo student= repo.findById(id).get();
		 return student;
	 
}
	 @PostMapping("/student/add")
	 @ResponseStatus(code=HttpStatus.CREATED)
	 public  void  CreateStudent(@RequestBody StudentPojo student){
		  repo.save(student);
		
	 }
	 @PutMapping("/student/update/{id}")
	 public StudentPojo UpdateStudent(@PathVariable int id) {
		 StudentPojo student=repo.findById(id).get();
		 student.setName("pranjal");
		 student.setPercentage(98);
		 repo.save(student);
		 return student;
	 }
	 @DeleteMapping("/student/delete/{id}")
	 public void removeStudent(@PathVariable int id) {
		 StudentPojo student =repo.findById(id).get();
		 repo.delete(student);
	 }
}