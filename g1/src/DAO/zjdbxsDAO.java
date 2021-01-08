package DAO;

import bean.zjdbxs;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import utils.DBhelper;

import java.sql.Connection;

public class zjdbxsDAO {
    public zjdbxs login(String admins, String pwd) throws Exception{//登录
        Connection conn = DBhelper.getConnection();
        String sql = "select admins = ?, pwd = ? from users";
        try {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, admins, pwd);
        }finally {
            DbUtils.closeQuietly(conn);
        }
        return  login(admins, pwd);
    }
}
