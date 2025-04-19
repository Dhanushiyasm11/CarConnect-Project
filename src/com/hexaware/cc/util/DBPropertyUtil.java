//@Author - Dhanushiya SM

package com.hexaware.cc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {

    public static String getConnectionString(String propertyFileName) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(propertyFileName)) {
            props.load(fis);
            return props.getProperty("db.url");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load DB property file.", e);
        }
    }
}
