package org.Rdx.employmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    // List<Employee> employees = new ArrayList<>();

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

}
