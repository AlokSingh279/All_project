package com.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByGmail(String gmail);
}
