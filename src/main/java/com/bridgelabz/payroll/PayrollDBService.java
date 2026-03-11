package com.bridgelabz.payroll;

import java.sql.Connection;
import java.sql.DriverManager;

public class PayrollDBService {

    private static final String URL =
            "jdbc:mysql://localhost:3306/payroll_service";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection =
                DriverManager.getConnection(URL, USER, PASSWORD);

        System.out.println("Connection established");

        return connection;
    }
}