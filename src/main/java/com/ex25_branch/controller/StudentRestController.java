package com.ex25_branch.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex25_branch.domain.Student;
import com.ex25_branch.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {

//	Dependency injection : 방법1
//	@Autowired
//	private StudentService studentService;

//	Dependency injection : 방법2
//	private final StudentService studentService;
//	public StudentRestController(StudentService studentService) {
//		this.studentService = studentService;
//	}

//	Dependency injection : 방법3-롬복
//	@RequiredArgsConstructor
//	public class StudentRestController {
//		private final StudentService studentService;
//	}

	private final StudentService studentService;

//	전체 조회: GET http://localhost:8080/api/students
	@GetMapping
	public List<Student> list() {
		return studentService.getAllStudents();
	}

//	단건 조회: GET http://localhost:8080/api/students/1
	@GetMapping("/{id}")
	public ResponseEntity<Student> detail(@PathVariable Long id) {
		Student student = studentService.getStudent(id);
		return ResponseEntity.ok(student);
	}

//	등록 :POST http://localhost:8080/api/students
//	{
//		"name":"테스트3",
//		"email":"kk@nate.com",
//		"age":25
//	}
	@PostMapping
	public ResponseEntity<Student> create(@RequestBody Student student) {

		studentService.createStudent(student);
		return ResponseEntity.ok(student);
	}

//	수정 put
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {

		student.setId(id);
		studentService.updateStudent(student);
		return ResponseEntity.ok(student);
	}

	// 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok().build();
	}


}
