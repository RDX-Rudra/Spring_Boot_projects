import React from 'react';

const Header = ({ onSelect }) => {
  return (
    <nav>
      <ul>
        <li onClick={() => onSelect('employees')}>Employees</li>
        <li onClick={() => onSelect('deleteEmployee')}>Delete Employee</li>
        <li onClick={() => onSelect('updateEmployee')}>Update Employee</li>
        <li onClick={() => onSelect('readEmployee')}>Read Employee</li>
      </ul>
    </nav>
  );
};

export default Header;
