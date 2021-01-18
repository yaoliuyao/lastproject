package dao;

import bean.Admin;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBHelper;
import java.sql.Connection;
import java.util.List;

public class AdminDao {
    /**
     * selectalladmin 查询所有管理员
     * updateadminpassword 更改管理员密码(待完善)
     *
     *
     *
     */
    public List<Admin> selectalladmin() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_admin";
        List<Admin> admins = null;
        try {
            QueryRunner runner = new QueryRunner();
            admins = runner.query(connection, sql, new BeanListHandler<Admin>(Admin.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return admins;
    }

    public void updateadminpassword(Admin admin) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "update book_admin set password = ? where uid = ?";
        try {
            Object[] objects = {
                    admin.getPassword(),admin.getUid()
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
