package com.example.employee_management_system.controller;

import com.example.employee_management_system.dto.EmployeeDto;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;


    // read , get all employees
    @GetMapping("/")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee addEmployee(@PathVariable("id") Long id) {
        return employeeService.getById(id);
    }


    // create
    @PostMapping("/")
    public Employee addEmployee(@Valid @RequestBody EmployeeDto employee) {
        return employeeService.saveEmployee(employee);
    }


    //update
    @PatchMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }


    //delete
   @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "deleted Succefully";
    }


}
