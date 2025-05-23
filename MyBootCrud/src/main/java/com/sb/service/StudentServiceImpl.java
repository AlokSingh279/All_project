package com.sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.entity.Student;
import com.sb.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepository;

	@Override
	public boolean addStudent(Student student) {

		Student save = studentRepository.save(student);

		if (save != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Student> list() {

		List<Student> all = studentRepository.findAll();
		return all;
	}

	@Override
	public Student getStudentById(long id) {

		Optional<Student> optional = studentRepository.findById(id);

		if (optional.isPresent()) {
			Student student = optional.get();
			return student;
		}

		return null;
	}

	@Override
	public void updateStudent(Student student, long id) {

		Student studen = getStudentById(id);
		studen.setCity(student.getCity());
		studen.setEmail(student.getEmail());
		studentRepository.save(studen);

	}

	@Override
	public void deleteStudent(long id) {
		
		studentRepository.deleteById(id);
		
	}

}
