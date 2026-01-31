package com.example.employee_management_system.service;

import com.example.employee_management_system.dto.EmployeeDto;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.exception.AppException;
import com.example.employee_management_system.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public List<Employee> getEmployees(){
        return employeeRepository.findAll(); // to fetch all employees from the data base
    }

    public Employee saveEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee();
        employee.setAge(employeeDto.getAge());
        employee.setId(employee.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        return employeeRepository.save(employee); // to save the employee in the database
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee); // to save the employee in the database
    }

    public String  deleteEmployee(Long id){
        Employee employee=employeeRepository.findById(id)
                        .orElseThrow(()->
                                new AppException("Employee Not Found"+ id));

        employeeRepository.deleteById(id); // delete emplyee
        return "DELETED SUCESSFULLY";
    }


    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(()->
               new AppException("invalid id"+id) );
    }
}
