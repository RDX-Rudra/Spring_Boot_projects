package org.Rdx.employmanagement;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        employees.add(employee);
        return "saved successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        employees.remove(id);
        return true;
    }

}
