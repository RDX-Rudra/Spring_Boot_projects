import React, { useState, useEffect } from 'react';
import EmployeeForm from './EmployeeForm';
import EmployeeList from './EmployeeList';

const App = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    fetchEmployees();
  }, []);

  const fetchEmployees = () => {
    fetch('http://localhost:8080/employees')
      .then((response) => response.json())
      .then((data) => setEmployees(data))
      .catch((error) => console.error('Error:', error));
  };

  const addEmployee = (employee) => {
    fetch('http://localhost:8080/employees', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(employee),
    })
      .then((response) => response.json())
      .then((data) => {
        fetchEmployees();
      })
      .catch((error) => console.error('Error:', error));
  };

  const deleteEmployee = (id) => {
    fetch(`http://localhost:8080/employees/${id}`, {
      method: 'DELETE',
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        fetchEmployees();
      })
      .catch((error) => console.error('Error:', error));
  };

  const updateEmployee = (id, employee) => {
    fetch(`http://localhost:8080/employees/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(employee),
    })
      .then((response) => response.json())
      .then((data) => {
        fetchEmployees();
      })
      .catch((error) => console.error('Error:', error));
  };

  return (
    <div>
      <h1>Employee Management System</h1>
      <EmployeeForm addEmployee={addEmployee} />
      <EmployeeList employees={employees} onDelete={deleteEmployee} onUpdate={updateEmployee} />
    </div>
  );
};

export default App;
