package com.bridgelabz.payroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 PayrollDBService

 This class is responsible for establishing
 a connection between the Java application
 and the MySQL payroll_service database.

 It loads the JDBC driver and returns
 a connection object used by the service layer.
*/

public class PayrollDBService {

    private static final String URL =
            "jdbc:mysql://localhost:3306/payroll_service";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // method to establish database connection
    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        // load JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // create connection
        Connection connection =
                DriverManager.getConnection(URL, USER, PASSWORD);

        System.out.println("Connection Established");

        return connection;
    }
}