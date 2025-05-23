package com.sb.service;

import java.util.List;

import com.sb.entity.Student;

public interface StudentService {

	public boolean addStudent(Student student);
	
	public List<Student> list();
	
	public Student getStudentById(long id);
	
	public void updateStudent(Student student,long id);
	
	public void deleteStudent(long id);
}
