package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBhelper {
    public static Connection getConnection() throws Exception {
        String user = "sa";
        String password = "123456";
        String dataBase = "FD";
        String host = "localhost";
        String url = "jdbc:sqlserver://" + host + ";databaseName=" + dataBase + ";user=" + user + ";password=" + password;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url);
    }
}