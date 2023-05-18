package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Service.EmployeeService;
import com.codeline.sampleProject.responseobject.GetEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("employee/create")
    public void saveEmployee() {
        createEmployee();
    }
    @RequestMapping("employee/get")
    public List<Employee> getEmployees () {
        return employeeService.getEmployees();
    }
    //Path Variable
    @RequestMapping("employee/get/{employeeId}")
    public GetEmployeeResponse createEmployee (@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    public void createEmployee() {

        Employee employee = new Employee();
        employee.setName("Abdullah");
        employee.setGender("Male");
        employee.setSalary(650.0);
        employee.setDepartment("IT");
        employee.setCompanyName("TechM");
        employee.setCreatedDate(new Date());
        employee.setIsActive(true);
        employeeService.saveEmployee(employee);
    }
    @RequestMapping("employee/delete/{Id}")
    public void deleteeemployee (@PathVariable Long Id) {
        employeeService.deleteEmployeeById(Id);
    }

}