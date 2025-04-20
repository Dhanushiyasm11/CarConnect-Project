//@Author - Akshaya

package com.hexaware.cc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {

   
    public static Connection getConnection(String connectionString) {
        Connection conn = null;
        try {
           
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();  
        }
        return conn;
    }
}