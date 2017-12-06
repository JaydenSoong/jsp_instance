package com.jayden.utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static Properties props = null;
    static {
        props = new Properties();
        InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Class.forName(props.getProperty("driverClassName"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(props.getProperty("url"), props.getProperty("uname"), props.getProperty("pwd"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
