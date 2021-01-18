package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    /**
     * getConnection()连接数据库
     *
     *
     *
     *
     */
    public static Connection getConnection() throws Exception {
        String user = "sa";
        String password = "2538936912";
        String dataBase = "bookShop";
        String host = "localhost:1433";
        String url = "jdbc:sqlserver://" + host + ";databaseName=" + dataBase + ";user=" + user + ";password=" + password;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url);
    }
}