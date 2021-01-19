package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBhelp {
    public static Connection getConnection() throws Exception {
        String user = "sa";
        String password = "zmp1006";
        String dataBase = "vueproject";
        String host = "localhost:1433";
        String url = "jdbc:sqlserver://" + host + ";databaseName=" + dataBase + ";user=" + user + ";password=" + password;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url);
    }
}
