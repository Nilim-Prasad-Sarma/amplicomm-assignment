package com.te.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.employee.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
