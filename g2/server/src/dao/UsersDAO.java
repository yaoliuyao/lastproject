package dao;

import bean.Users;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utile.DBHelper;

import java.math.BigDecimal;
import java.sql.Connection;

public class UsersDAO {
    /*添加用户*/
    public Users addUser(Users users)throws Exception{
        Connection connection =DBHelper.getConnection();
        String sql = "insernt into users  values(username,passwords ,phone,usertype,image )";
        Object [] par = {
                users.getImage(),users.getPassword(),users.getUsername(), users.getPhone()
        };
        try{
            QueryRunner runner =new QueryRunner();
            return  runner.query(connection,sql,new BeanHandler<>(Users.class),par);
        }finally {
            DbUtils.closeQuietly(connection);
        }
    }
    /*删除用户*/
    public void delete(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from details where id = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    /*修改密码*/
    public void update(int id, String passwords) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update user set passwords = ? where id = ?";
        try {
            new QueryRunner().update(conn, sql, passwords,id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    
}
