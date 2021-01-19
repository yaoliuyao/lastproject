package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBHelper {


    public static String driver;
    public static String dbUrl;
    public static String dbUser;
    public static String dbPwd;

    public Connection connection;
    public PreparedStatement preparedStatement;
    public ResultSet resultSet;

    static {
        InputStream inputStream = DBHelper.class.getResourceAsStream("/jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            driver = properties.getProperty("jdbc.driver");
            dbUrl = properties.getProperty("jdbc.dbUrl");
            dbUser = properties.getProperty("jdbc.dbUser");
            dbPwd = properties.getProperty("jdbc.dbPwd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }   
}

