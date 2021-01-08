package mv.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    public static Connection getConnection() throws Exception {
        String user = "sa";
        String pwd = "ZZDxsxcyh211522";
        String database = "Mymv";
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName="
                +database+ ";user=" +user + ";password=" +pwd;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url);
    }
}