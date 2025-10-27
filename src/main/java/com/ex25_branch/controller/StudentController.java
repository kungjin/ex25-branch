package com.ex25_branch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex25_branch.domain.Student;
import com.ex25_branch.service.StudentService;

import lombok.RequiredArgsConstructor;





@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
	
	private final StudentService studentService;
//	화면: 전체 학생 목록 
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		
		return "student/list";
		
	
	}
	
//	form 화면: 새로운 학생 정보를 입력하기 위한 빈화면.
	@GetMapping("/new")
	public String getMethodName(Model model) {
		model.addAttribute("student", new Student());
		return"student/form";
	}
	
//	학생정보 기록후 저장버튼 클릭을 하면, 학생정보를 insert
	@PostMapping
	public String create(@ModelAttribute Student student) {
//		이미 학생이 저장이 완료되요
		studentService.createStudent(student);	
		return "redirect:/students";
	}
	
	
// 학생정보 form 에서 수정하기 	
	@GetMapping("/{id}/edit")
	public String getMethodEdit(@PathVariable Long id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "student/form";
	}
	
//	학생정보 업데이트 
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, @ModelAttribute Student student) {
		student.setId(id); // 경로변수로 안전 고정 
		studentService.updateStudent(student);	
		return "redirect:/students";
	}
	
//	학생정보 삭제 
	@PostMapping("/{id}/delete")
	public String delet(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return"redirect:/students";
	}
	
	
	
	
}
