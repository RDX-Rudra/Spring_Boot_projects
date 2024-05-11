package org.Rdx.employmanagement;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin("htpp://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmpController {
    
    // List<Employee> employees = new ArrayList<>();
    // EmployeeService employeeService = new EmployeeServiceImpl();
    // Dependency Injection
    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        
        return employeeService.readEmployees();
    }
    @GetMapping("employees/{id}")
    public Employee getEmployeesById(@PathVariable Long id) {
        
        return employeeService.readEmployee(id);
    }
    
    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        // employees.add(employee);
        return employeeService.createEmployee(employee);
        
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id))
            return "Delete Successfully";
        else
            return "Not found";
    }

    @RequestMapping("employees/{id}")
    public String requestMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
    
    
}
