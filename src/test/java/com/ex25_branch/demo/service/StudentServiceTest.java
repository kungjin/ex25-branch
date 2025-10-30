package com.ex25_branch.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.ex25_branch.demo.domain.StudentTest;
import com.ex25_branch.demo.mapper.StudentMapperTest;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentServiceTest {
	@Autowired
	private StudentMapperTest studentMapperTest;
	
	@Test
	@DisplayName("학생 등록후 조회 확인(TDD)")
	void testRegisterAndFind() {
//		given
		StudentTest s1 = StudentTest.builder().name("홍길동1").email("hong1@jjj.com").age(22).build();
		StudentTest s2 = StudentTest.builder().name("홍길동2").email("hong2@test.com").age(20).build();
		
//		when
		int result = studentMapperTest.insert(s1);
		
//		then
		assertEquals(1,result,"등록은 1건 성공해야 한다."); 
		assertNotNull(s1.getId(), "등록 후 id가 자동 생성되어야 한다.");
		
		StudentTest findStudent = studentMapperTest.findById(s1.getId());
	}
	
	@Test
	@DisplayName("학생 전체 조회(TDD)")
	void testFindAll() {
	    StudentTest s3 = StudentTest.builder().name("홍길동3").email("hong3@test.com").age(23).build();
	    StudentTest s4 = StudentTest.builder().name("홍길동4").email("hong4@test.com").age(24).build();
	    studentMapperTest.insert(s3);
	    studentMapperTest.insert(s4);

	    List<StudentTest> students = studentMapperTest.findAll();

	    // ✅ 콘솔 출력 (System.out)
	    System.out.println("==== 전체 학생 목록 ====");
	    students.forEach(s -> System.out.println(s));

	    // ✅ 또는 log.info() (Lombok @Slf4j 필요)
	    // log.info("전체 학생 목록: {}", students);

	    assertTrue(students.size() >= 2);
	    assertEquals("홍길동4", students.get(0).getName());
	}

		
	}

