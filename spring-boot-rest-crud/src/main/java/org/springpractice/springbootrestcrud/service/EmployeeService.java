package org.springpractice.springbootrestcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springpractice.springbootrestcrud.dao.EmployeeRepository;
import org.springpractice.springbootrestcrud.entity.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);

        if (result.isPresent()) {
            return result.get();
        }

        throw new RuntimeException("Employee not found. ID : " + id);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

}
