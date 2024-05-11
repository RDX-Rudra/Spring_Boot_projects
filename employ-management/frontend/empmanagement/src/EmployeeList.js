import React from 'react';

const EmployeeList = ({ employees }) => {
  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Phone Number</th>
          <th>Email</th>
        </tr>
      </thead>
      <tbody>
        {employees.map((employee) => (
          <tr key={employee.id}>
            <td>{employee.id}</td>
            <td>{employee.name}</td>
            <td>{employee.phNo}</td>
            <td>{employee.email}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default EmployeeList;
