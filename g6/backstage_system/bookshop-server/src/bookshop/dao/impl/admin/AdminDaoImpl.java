package bookshop.dao.impl.admin;

import bookshop.dao.AdminDao;
import bookshop.entity.Admin;
import bookshop.utils.DBHelper;
import bookshop.vo.ResultVO;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin adminLogin(String user, String password) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select uid,[user],password,state,createTime from book_admin " +
                "where [user] =? and password = ?";
        try {
            Admin admin = new QueryRunner().query(conn, sql, new BeanHandler<>(Admin.class),user,password);
            return admin;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public static void main(String[] args) throws Exception {
        Admin admin = new AdminDaoImpl().adminLogin("admin", "123");
        System.out.println(ResultVO.success(admin,"g").toJSON());
    }
}
