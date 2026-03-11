USE payroll_service;

CREATE TABLE employee_payroll(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(150) NOT NULL,
salary DOUBLE NOT NULL,
start DATE NOT NULL
);