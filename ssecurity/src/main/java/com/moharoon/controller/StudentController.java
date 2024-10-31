package com.moharoon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moharoon.model.Student;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	
	List<Student> students = new ArrayList<>(List.of(
			  new Student(1, "Haroon", 100),
			  new Student(2, "mohammed haroon", 99),
			  new Student(3, "mohd_haroon", 98)
			));
	
	
	
	@GetMapping("/get")
	public ResponseEntity<List<Student>> getStudents() {
		return ResponseEntity.ok(students);
	}
	
	

	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		students.add(student);
		return ResponseEntity.ok(student);
	}
	
	
	

}
