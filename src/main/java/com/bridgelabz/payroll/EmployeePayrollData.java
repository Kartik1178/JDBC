package com.bridgelabz.payroll;

import java.time.LocalDate;

/*
 EmployeePayrollData

 This class represents a single employee payroll record
 retrieved from the payroll_service database.

 Each object maps one row from the employee_payroll table.
*/

public class EmployeePayrollData {

    public int id;
    public String name;
    public double salary;
    public LocalDate startDate;

    public EmployeePayrollData(int id,String name,double salary,LocalDate startDate){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.startDate=startDate;
    }
}