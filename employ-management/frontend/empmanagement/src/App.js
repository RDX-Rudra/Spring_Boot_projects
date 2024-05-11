import React, { useState, useEffect } from 'react';
import Header from './Header';
import {
  getAllEmployees,
  getEmployeeById,
  createEmployee,
  deleteEmployee,
  updateEmployee,
} from './EmployeeService';

const App = () => {
  const [content, setContent] = useState('employees');
  const [employees, setEmployees] = useState([]);
  const [employee, setEmployee] = useState({});
  const [newEmployee, setNewEmployee] = useState({
    name: '',
    phNo: '',
    email: '',
  });

  useEffect(() => {
    fetchEmployees();
  }, []);

  const fetchEmployees = async () => {
    const data = await getAllEmployees();
    setEmployees(data);
  };

  const fetchEmployeeById = async (id) => {
    const data = await getEmployeeById(id);
    setEmployee(data);
  };

  const handleSelect = (content) => {
    setContent(content);
  };

  const handleDelete = async (id) => {
    await deleteEmployee(id);
    await fetchEmployees();
  };

  const handleUpdate = async (id, updatedEmployee) => {
    await updateEmployee(id, updatedEmployee);
    await fetchEmployees();
  };

  const handleCreate = async () => {
    await createEmployee(newEmployee);
    await fetchEmployees();
    setNewEmployee({ name: '', phNo: '', email: '' });
  };

  return (
    <div>
      <Header onSelect={handleSelect} />
      {content === 'employees' && (
        <div>
          <h1>Employees</h1>
          <ul>
            {employees.map((emp) => (
              <li key={emp.id}>{emp.name}</li>
            ))}
          </ul>
        </div>
      )}
      {content === 'deleteEmployee' && (
        <div>
          <h1>Delete Employee</h1>
          <button onClick={() => handleDelete(1)}>Delete</button>
        </div>
      )}
      {content === 'updateEmployee' && (
        <div>
          <h1>Update Employee</h1>
          <button onClick={() => handleUpdate(1, { name: 'Updated Employee' })}>
            Update
          </button>
        </div>
      )}
      {content === 'readEmployee' && (
        <div>
          <h1>Read Employee</h1>
          <button onClick={() => fetchEmployeeById(1)}>Fetch</button>
          <p>{JSON.stringify(employee)}</p>
        </div>
      )}
      <div>
        <h2>Add Employee</h2>
        <input
          type="text"
          placeholder="Name"
          value={newEmployee.name}
          onChange={(e) => setNewEmployee({ ...newEmployee, name: e.target.value })}
        />
        <input
          type="text"
          placeholder="Phone Number"
          value={newEmployee.phNo}
          onChange={(e) => setNewEmployee({ ...newEmployee, phNo: e.target.value })}
        />
        <input
          type="text"
          placeholder="Email"
          value={newEmployee.email}
          onChange={(e) => setNewEmployee({ ...newEmployee, email: e.target.value })}
        />
        <button onClick={handleCreate}>Add</button>
      </div>
    </div>
  );
};

export default App;
