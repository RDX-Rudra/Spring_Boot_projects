import React, { useState } from 'react';

const EmployeeForm = ({ addEmployee }) => {
  const [name, setName] = useState('');
  const [phNo, setPhNo] = useState('');
  const [email, setEmail] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!name || !phNo || !email) return;
    addEmployee({ name, phNo, email });
    setName('');
    setPhNo('');
    setEmail('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" placeholder="Name" value={name} onChange={(e) => setName(e.target.value)} required />
      <input type="tel" placeholder="Phone Number" value={phNo} onChange={(e) => setPhNo(e.target.value)} required />
      <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />
      <button type="submit">Add Employee</button>
    </form>
  );
};

export default EmployeeForm;
