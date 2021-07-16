package com.expedia.interview.selenium;

import java.sql.*;

public class JDBC_Connections {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("URl OF JDBC", "USERNAME", "PASSWORD");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM countries");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString("firstName") + resultSet.getString("LastName"));

            connection.close();
        }
    }
}
