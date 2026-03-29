package org.springpractice.springbootdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springpractice.springbootdatarest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
