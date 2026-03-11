# JDBC Employee Payroll Service

## Overview

This project implements an **Employee Payroll Service using Java JDBC and MySQL**.
The system performs CRUD operations and analytical queries on employee payroll data stored in a MySQL database.

The implementation follows **GitFlow branching strategy**, where each use case is developed in a separate feature branch and later merged into the `develop` branch.

The final stable version is maintained in the `master` branch.

---

## Technologies Used

* **Java 17**
* **JDBC**
* **MySQL**
* **Maven**
* **JUnit**
* **Git & GitFlow**
* **IntelliJ IDEA**

---

## Project Structure

```
JDBC
│
├── docs
│
├── sql
│   ├── UC1_create_database.sql
│   ├── UC2_create_employee_table.sql
│   ├── UC3_insert_data.sql
│   ├── UC4_queries.sql
│
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── bridgelabz
│   │               └── payroll
│   │                   ├── EmployeePayrollData.java
│   │                   ├── PayrollDBService.java
│   │                   └── EmployeePayrollService.java
│   │
│   └── test
│       └── java
│           └── com
│               └── bridgelabz
│                   └── payroll
│                       └── EmployeePayrollTest.java
│
├── pom.xml
└── README.md
```

---

## Database Configuration

MySQL Database:

```
Database Name: payroll_service
Port: 3306
Host: localhost
```

JDBC Connection URL used:

```
jdbc:mysql://localhost:3306/payroll_service
```

---

## Implemented Use Cases

### UC1 — Database Connection

Establish a connection between the Java application and MySQL database using JDBC.

### UC2 — Retrieve Employee Payroll Data

Read employee payroll records from the database.

### UC3 — Update Employee Salary

Update salary of an employee and verify the updated value.

### UC4 — Prepared Statement Implementation

Retrieve employee payroll data using PreparedStatement.

### UC5 — Retrieve Employees by Date Range

Retrieve employees whose joining date falls between two specified dates.

### UC6 — Salary Analytics

Perform aggregate operations grouped by gender:

* SUM of salaries
* AVG salary
* MIN salary
* MAX salary
* COUNT of employees

---

## GitFlow Workflow

Each use case was implemented using a **feature branch**.

Example workflow:

```
git flow feature start jdbc-uc1-db-connect
git add .
git commit -m "[Kartikeya]: Implemented UC1 database connection"
git push origin feature/jdbc-uc1-db-connect

git flow feature finish -k jdbc-uc1-db-connect
git push origin develop
```

Feature branches used:

```
feature/jdbc-uc1-db-connect
feature/jdbc-uc2-read-payroll
feature/jdbc-uc3-update-salary
feature/jdbc-uc4-prepared-statement
feature/jdbc-uc5-date-range
feature/jdbc-uc6-salary-statistics
```

---

## How to Run the Project

1. Clone the repository

```
git clone https://github.com/Kartik1178/JDBC.git
```

2. Navigate to the project directory

```
cd JDBC
```

3. Ensure MySQL database is running and `payroll_service` database exists.

4. Run the project using Maven:

```
mvn clean install
```

5. Run the test cases:

```
mvn test
```

---

## Author

**Kartikeya**

GitHub:
https://github.com/Kartik1178
