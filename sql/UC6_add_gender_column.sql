ALTER TABLE employee_payroll
ADD gender CHAR(1) AFTER name;

UPDATE employee_payroll
SET gender='M'
WHERE name='Bill' OR name='Charlie';