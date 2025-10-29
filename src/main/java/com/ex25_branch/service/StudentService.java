package com.ex25_branch.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex25_branch.domain.Student;
import com.ex25_branch.mapper.StudentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

	private final StudentMapper studentMapper;

	public List<Student> getAllStudents() {

		return studentMapper.findAll();
//		List<Student> studens = new ArrayList<>();
//		studens.add(new Student() {{setId(1L); setName("홍길동");}});
//		studens.add(new Student() {{setId(2L); setName("이몽룡");}});
//		studens.add(new Student() {{setId(3L); setName("성춘향");}});
//		return studens;
	}

	public Student getStudent(Long id) {
		return studentMapper.findById(id);
	}

	@Transactional
	public void createStudent(Student student) {
		studentMapper.insert(student);

	}

	@Transactional
	public void updateStudent(Student student) {
		studentMapper.update(student);
	}

	@Transactional
	public void deleteStudent(Long id) {
		studentMapper.delete(id);
	}

	public Student getStudentById(Long id) {
		return studentMapper.findById(id);
	}

}
