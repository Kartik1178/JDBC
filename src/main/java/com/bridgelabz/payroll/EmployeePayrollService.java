package com.bridgelabz.payroll;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 EmployeePayrollService

 This service class contains business logic
 used to interact with the payroll database
 using JDBC.

 It performs operations like retrieving employees,
 updating salary, and analytics.
*/

public class EmployeePayrollService {

    // method to retrieve employee payroll data
    public List<EmployeePayrollData> readData() {

        List<EmployeePayrollData> employeeList = new ArrayList<>();

        try {

            // get database connection
            Connection con = PayrollDBService.getConnection();

            // create statement
            Statement stmt = con.createStatement();

            // execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee_payroll");

            // iterate through results
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");

                EmployeePayrollData employee =
                        new EmployeePayrollData(id,name,salary,null);

                employeeList.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeList;
    }
}