const API_BASE_URL = 'http://localhost:8080/api/v1/';

const request = async (options) => {
  const response = await fetch(options.url, options);
  const data = await response.json();
  if (!response.ok) {
    throw new Error(data.message);
  }
  return data;
};

export const getAllEmployees = async () => {
  return await request({
    url: `${API_BASE_URL}employees`,
    method: 'GET',
  });
};

export const getEmployeeById = async (id) => {
  return await request({
    url: `${API_BASE_URL}employees/${id}`,
    method: 'GET',
  });
};

export const createEmployee = async (employee) => {
  return await request({
    url: `${API_BASE_URL}employees`,
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(employee),
  });
};

export const deleteEmployee = async (id) => {
  return await request({
    url: `${API_BASE_URL}employees/${id}`,
    method: 'DELETE',
  });
};

export const updateEmployee = async (id, employee) => {
  return await request({
    url: `${API_BASE_URL}employees/${id}`,
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(employee),
  });
};
