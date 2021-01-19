package mv.daoguanli;

import mv.beanguanli.GuanLy;
import mv.utils.DBHelper;
<<<<<<< HEAD
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
=======
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GuanDao {

    public int zc(GuanLy guanLy) throws Exception {
        String sql = "insert into gly values(?,?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, guanLy.getGname());
            pr.setString(2, guanLy.getGpwd());
            pr.setString(3, guanLy.getGtp());

            int c = pr.executeUpdate();
            return c;
        }
    }


    public GuanLy dl(String name, String pwd) throws Exception {
        String sql = "select * from gly where gname =? and gpwd =?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, name);
            pr.setString(2, pwd);
            try (ResultSet resultSet = pr.executeQuery()){
                if (resultSet.next()) {
                    GuanLy guanLy = new GuanLy();
                    guanLy.setGname(resultSet.getString(2));
                    guanLy.setGpwd(resultSet.getString(3));
                    guanLy.setGtp(resultSet.getString(4));
                    return guanLy;
                }
                else {
                    return null;
                }
            }
        }
    }

    public String dltx(String name) throws Exception {
        String sql = "select gtp from gly where gname =?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, name);
            try (ResultSet resultSet = pr.executeQuery()){
                if (resultSet.next()) {
                    String tx = resultSet.getString(1);
                    return tx;
                }
                else {
                    return null;
                }
            }
        }
    }


<<<<<<< HEAD
    public void jiechufenhao(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update yonhu set viptime1 = 1 where id = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


=======
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa

}
