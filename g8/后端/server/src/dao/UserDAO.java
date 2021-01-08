package dao;

import DB.DBhelp;
import bean.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.util.UUID;

public class UserDAO {
    /**
     * 新用户注册
     */
    public User addUser(User user) throws Exception {
        Connection conn = DBhelp.getConnection();
        String sql = "insert into user_table (id, username, user_password) values (?,?,?)";
        try{
        QueryRunner qr = new QueryRunner();
        Object[] params = {UUID.randomUUID(),user.getUsername(),user.getPassword()};
        qr.update(conn,sql,params);
        return user;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 用户登录
     * @return
     */
    public User denglu(String username, String password) throws Exception {
        Connection conn = DBhelp.getConnection();
        String sql = "select username = ?, user_password = ? from user_table";
        try{
            QueryRunner run = new QueryRunner();
            run.update(conn,sql,username,password);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return denglu(username,password);
    }
}
