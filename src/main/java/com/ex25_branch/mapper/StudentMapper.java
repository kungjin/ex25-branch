package com.ex25_branch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ex25_branch.domain.Student;

@Mapper
public interface StudentMapper {

	List<Student> findAll();
	
	@Select("SELECT * FROM student WHERE id = #{id}")
	Student findById(Long id);

	@Insert("INSERT INTO student(NAME, email, age) \r\n"
			+ "  	VALUES (#{name}, #{email}, #{age})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Student student);

	@Update("UPDATE student\r\n"
			+ "	SET NAME = #{name}, email = #{email}, age = #{age}\r\n"
			+ "	WHERE id = #{id}")
	void update(Student student);

	@Delete("DELETE FROM student WHERE id = #{id}")
	void delete(Long id);

}
