package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
        public static Connection getConnection() throws SQLException {   
              try {   
                     Class.forName("com.mysql.jdbc.Driver"); 
                     return DriverManager.getConnection("jdbc:mysql://localhost:3306/jpa","root","");   
              } catch (ClassNotFoundException e) {   
                     throw new SQLException(e.getMessage());   
              }   
        }   
}
