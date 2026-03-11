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
    // method to retrieve employees within date range
    public List<EmployeePayrollData> getEmployeesByDateRange(Date start,Date end){

        List<EmployeePayrollData> list=new ArrayList<>();

        try{

            Connection con=PayrollDBService.getConnection();

            String query=
                    "SELECT * FROM employee_payroll WHERE start BETWEEN ? AND ?";

            PreparedStatement pstmt=con.prepareStatement(query);

            pstmt.setDate(1,start);
            pstmt.setDate(2,end);

            ResultSet rs=pstmt.executeQuery();

            while(rs.next()){

                list.add(new EmployeePayrollData(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        null
                ));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
    // method to calculate salary statistics grouped by gender
    public void getSalaryStatisticsByGender() {

        try {

            // establish database connection
            Connection connection = PayrollDBService.getConnection();

            String query =
                    "SELECT gender, SUM(salary), AVG(salary), MIN(salary), MAX(salary), COUNT(*) " +
                            "FROM employee_payroll GROUP BY gender";

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                String gender = rs.getString(1);
                double sum = rs.getDouble(2);
                double avg = rs.getDouble(3);
                double min = rs.getDouble(4);
                double max = rs.getDouble(5);
                int count = rs.getInt(6);

                System.out.println(
                        "Gender: " + gender +
                                " | Total Salary: " + sum +
                                " | Avg Salary: " + avg +
                                " | Min Salary: " + min +
                                " | Max Salary: " + max +
                                " | Count: " + count
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}