//@Author - Dhanushiya SM

package com.hexaware.cc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    public static Properties loadProperties(String filename) throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(filename);
        props.load(fis);
        return props;
    }
}

