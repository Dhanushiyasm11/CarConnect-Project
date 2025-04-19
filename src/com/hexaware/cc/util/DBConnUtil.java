package com.hexaware.cc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnUtil {
    public static Connection getConnection(Properties props) throws SQLException {
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, user, password);
    }
}