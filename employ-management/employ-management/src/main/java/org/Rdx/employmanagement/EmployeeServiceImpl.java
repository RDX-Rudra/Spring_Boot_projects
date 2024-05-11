package org.Rdx.employmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Import Service annotation

@Service // Add Service annotation
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee) {
        EmployEntity employEntity = new EmployEntity();
        BeanUtils.copyProperties(employee, employEntity);
        employeeRepository.save(employEntity);
        return "saved successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmployEntity employEntity : employeesList) {
            Employee emp = new Employee();
            emp.setName(employEntity.getName());
            emp.setId(employEntity.getId());
            emp.setPhNo(employEntity.getPhNo());
            emp.setEmail(employEntity.getEmail());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployEntity newEmployee = employeeRepository.findById(id).get();
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPhNo(employee.getPhNo());
        newEmployee.setName(employee.getName());
        employeeRepository.save(newEmployee);
        return "updated successfully";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployEntity newEmployee = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(newEmployee, employee);
        return employee;
    }
}
