package org.springpractice.springbootrestcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springpractice.springbootrestcrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {



}
