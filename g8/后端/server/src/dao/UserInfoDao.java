package dao;

import DB.DBhelp;
import bean.UserInfo;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.util.UUID;

public class UserInfoDao {
    /*
    * 用户注册
    **/
    public UserInfo addUser(UserInfo userInfo) throws Exception{
        Connection connection = DBhelp.getConnection();
        String sql = "insert into userInfo (id,username,password " +
                " sex,face,regTime,email,mobile) values(?,?,?,?,?,?,?,?)";
        try {
            QueryRunner qr = new QueryRunner();
            Object[] params = {UUID.randomUUID(),userInfo.getUsername(),
                    userInfo.getPassword(),userInfo.getSex(),userInfo.getFace(),
                    userInfo.getRegTime(),userInfo.getMobile()};
            qr.update(connection,sql,params);
            return userInfo;
        } finally {
            DbUtils.closeQuietly(connection);
        }

    }

    /*
    *用户登录
    * */
    public UserInfo login (String username,String password) throws Exception{
        Connection conn = DBhelp.getConnection();
        String sql ="select username = ?, password = ? from UserInfo";

        try {
            QueryRunner qr = new QueryRunner();
            qr.update(conn,sql,username,password);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return login(username,password);
    }


    
}
