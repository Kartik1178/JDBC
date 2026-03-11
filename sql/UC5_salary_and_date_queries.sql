SELECT salary FROM employee_payroll
WHERE name = 'Bill';

SELECT * FROM employee_payroll
WHERE start BETWEEN CAST('2018-01-01' AS DATE)
AND DATE(NOW());