package mv.daoyonhu;

import mv.beanguanli.GuanLy;
<<<<<<< HEAD
import mv.beanyonhu.Jingao;
import mv.beanyonhu.YonHu;
import mv.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
=======
import mv.beanyonhu.YonHu;
import mv.utils.DBHelper;
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class YonhuDao {

    public int zc(YonHu yonHu) throws Exception {
        String sql = "insert into yonhu(name,pwd,tp) values(?,?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, yonHu.getName());
            pr.setString(2, yonHu.getPwd());
            pr.setString(3, yonHu.getTp());

            int c = pr.executeUpdate();
            return c;
        }
    }


    public YonHu dl(String name, String pwd) throws Exception {
        String sql = "select * from yonhu where name =? and pwd =?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, name);
            pr.setString(2, pwd);
            try (ResultSet resultSet = pr.executeQuery()){
                if (resultSet.next()) {
                    YonHu yonHu = new YonHu();
                    yonHu.setId(resultSet.getInt(1));
                    yonHu.setName(resultSet.getString(2));
                    yonHu.setPwd(resultSet.getString(3));
                    yonHu.setTp(resultSet.getString(4));
                    yonHu.setVip(resultSet.getInt(5));
                    yonHu.setViptime1(resultSet.getInt(6));
                    yonHu.setViptime2(resultSet.getInt(7));
                    yonHu.setViptime3(resultSet.getInt(8));
                    yonHu.setTime(resultSet.getDate(9));
                    return yonHu;
                }
                else {
                    return null;
                }
            }
        }
    }



    public String yhdltx(String name) throws Exception {
        String sql = "select tp from yonhu where name =?";
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
    public Jingao cxjg(int id) throws Exception {
        String sql = "select * from jiangao where id = ? and sf = 0 order by jgid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setInt(1, id);
            try (ResultSet resultSet = pr.executeQuery()){
                if (resultSet.next()) {
                    Jingao jingao = new Jingao();
                    jingao.setJgid(resultSet.getInt(1));
                    jingao.setId(resultSet.getInt(2));
                    jingao.setmComment(resultSet.getString(3));
                    jingao.setMtime(resultSet.getString(4));
                    return jingao;
                }
                else {
                    return null;
                }
            }
        }
    }

    public int getjgshuMount(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from jiangao where id = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void bianjg(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update jiangao set sf = 1 where jgid = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void femhao(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update yonhu set viptime1 = 999 where id = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


=======
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa
}
