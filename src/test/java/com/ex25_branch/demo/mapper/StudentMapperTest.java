package com.ex25_branch.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.ex25_branch.demo.domain.StudentTest;

@Mapper
public interface StudentMapperTest {
	@Select("SELECT * FROM student ORDER BY id DESC")
	List<StudentTest> findAll1();
	
	@Insert("INSERT INTO student(NAME, email, age) \r\n"
			+ "  	VALUES (#{name}, #{email}, #{age})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(StudentTest student);

	@Select("SELECT * FROM student ORDER BY #{id} DESC")
	List<StudentTest> findAll();
	
	@Select("SELECT * FROM student ORDER BY #{id} DESC")
	StudentTest findById(Long id);
	
}
