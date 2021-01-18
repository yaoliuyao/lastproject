package dao;

import bean.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBHelper;

import java.sql.Connection;
import java.util.List;

public class UserDao {
    /**
     * selectalluser 查询所有图书商品
     * selectbyphoneuser 根据手机号查找用户
     * adduser 注册用户
     * updateuserpass 修改用户密码(待完善)
     *
     */
    public List<User> selectalluser() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_user";
        List<User> users = null;
        try {
            QueryRunner runner = new QueryRunner();
            users = runner.query(connection, sql, new BeanListHandler<User>(User.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return users;
    }

    public User selectbyphoneuser(String phone,String userpass) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_user where phone = ? and userpass = ?";
        User users = null;
        try {
            QueryRunner runner = new QueryRunner();
            users = runner.query(connection,sql, new BeanHandler<User>(User.class),phone,userpass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return users;
    }
    public User selectbyphone(String phone) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_user where phone = ?";
        User users = null;
        try {
            QueryRunner runner = new QueryRunner();
            users = runner.query(connection,sql, new BeanHandler<User>(User.class),phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return users;
    }

    public void adduser(User user) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "insert into book_user(username,userpass,phone) values(?,?,?)";
        try {
            Object[] object = {
                    user.getUsername(),user.getUserpass(),user.getPhone()
            };
            QueryRunner runner = new QueryRunner();
            runner.update(connection,sql,object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
    }


    public void updateuserpass(User user) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "update book_user set userpass = ? where phone = ?";
        try {
            Object[] objects = {
                    user.getUserpass(),user.getPhone()
            };
            QueryRunner queryRunner = new QueryRunner();
            queryRunner.update(connection,sql,objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
    }
}
