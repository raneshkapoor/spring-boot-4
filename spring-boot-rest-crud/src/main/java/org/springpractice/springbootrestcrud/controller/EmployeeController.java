package org.springpractice.springbootrestcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springpractice.springbootrestcrud.entity.Employee;
import org.springpractice.springbootrestcrud.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee tempEmployee = employeeService.findById(id);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        employeeService.deleteById(id);
        return "Deleted employee id - " + id;
    }

}
