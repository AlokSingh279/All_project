package com.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
