package com.tca.dao;

import java.util.List;

import com.tca.entites.Student;

public interface StudentDao {
	
	 public abstract Integer saveStudent(Student student);
	 public abstract  Student findStudentById(Integer id);
	 public abstract List<Student> fetchStudentByName(String name);
	 public abstract List<Student> fetchStudentByCity(String city);
	 public abstract boolean updateStudent(Student student);
	 public abstract boolean deleteStudent(Student student);






}
