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
    // method to update employee salary
    public void updateSalary(String name,double salary){

        try{

            Connection con=PayrollDBService.getConnection();

            String query=
                    "UPDATE employee_payroll SET salary=? WHERE name=?";

            PreparedStatement pstmt=con.prepareStatement(query);

            pstmt.setDouble(1,salary);
            pstmt.setString(2,name);

            pstmt.executeUpdate();

            System.out.println("Salary Updated");

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    // method to retrieve employee by name
    public EmployeePayrollData getEmployeeByName(String name){

        try{

            Connection con=PayrollDBService.getConnection();

            String query="SELECT * FROM employee_payroll WHERE name=?";

            PreparedStatement pstmt=con.prepareStatement(query);

            pstmt.setString(1,name);

            ResultSet rs=pstmt.executeQuery();

            if(rs.next()){

                return new EmployeePayrollData(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        null
                );

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

}