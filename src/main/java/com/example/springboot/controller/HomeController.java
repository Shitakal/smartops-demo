package com.example.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Student;
import com.example.springboot.repository.StudentRepository;

@RestController
@RequestMapping("/")
public class HomeController { 
	@Autowired
	StudentRepository repository;
	
	@PostMapping("student")
	public void addStudent(@RequestBody Student stud) {
		repository.save(stud);
	}
	
	@GetMapping("student")
	public List<Student> getStudent(){
		return repository.findAll();
	}
	@DeleteMapping("student/{id}")
	public void deleteStudent(@PathVariable ("id") Long studId) {
		repository.deleteById(studId);
	}
	
	@GetMapping("student/{id}")
	public Optional<Student> findStudent(@PathVariable("id") Long studId) {
		return repository.findById(studId);
	}

	/*public String getMessage() {
		return"Hello from spring boot!";
	}
	
	@GetMapping("student")
	public List<Student> student(){
		List<Student> studList=new ArrayList<>();
		studList.add(new Student("rahul","sharma",112,"A+"));
		studList.add(new Student("priya","sharma",123,"A+"));
		studList.add(new Student("sneha","patil",124,"A+"));
		studList.add(new Student("raj","verma",125,"B"));
		studList.add(new Student("david","miller",126,"B+"));
		return studList;
	}*/

}
