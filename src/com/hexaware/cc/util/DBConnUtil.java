//@Author - Akshaya

package com.hexaware.cc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {

    private static final String DB_URL = DBPropertyUtil.getConnectionString("db.properties");
    private static final String DB_USER = "root"; 
    private static final String DB_PASS = "Dhanushiya@dhanu"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}