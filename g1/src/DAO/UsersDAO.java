package DAO;

import bean.Users;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import utils.DBhelper;

import java.sql.Connection;

public class UsersDAO {
    public Users AddUesrs(Users users) throws Exception{ /*注册*/
        Connection conn = DBhelper.getConnection();
        String sql = "insert into users values (?,?,?)";
        try {
            QueryRunner runner = new QueryRunner();
            Object[] objects = {
                    users.getUserid(),
                    users.getUphtot(),
                    users.getPwd(),
            };
            runner.update(conn, sql, objects);
        }finally {
            DbUtils.closeQuietly(conn);
        }
        return users;
    }

    public Users login(String Userid, String pwd) throws Exception{//登录
        Connection conn = DBhelper.getConnection();
        String sql = "select Userid = ?, pwd = ? from users";
        try {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, Userid, pwd);
        }finally {
            DbUtils.closeQuietly(conn);
        }
        return  login(Userid, pwd);
    }


}

