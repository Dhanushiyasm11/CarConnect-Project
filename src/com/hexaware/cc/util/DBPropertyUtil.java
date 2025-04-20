//@Author - Dhanushiya SM



package com.hexaware.cc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {

    
    public static String getConnectionString(String propertyFileName) {
        String connectionString = null;
        FileInputStream fis = null;
        try {
            
            Properties props = new Properties();
            fis = new FileInputStream(propertyFileName);
            props.load(fis);

        
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

           
            if (url == null || username == null || password == null) {
                throw new IllegalArgumentException("Missing database properties (url, username, password).");
            }

           
            connectionString = url + "?user=" + username + "&password=" + password;

        } catch (IOException e) {
            e.printStackTrace(); 
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();  
                }
            } catch (IOException e) {
                e.printStackTrace();  
            }
        }
        return connectionString;
    }
}