package mv.daoyonhu;

import mv.beanguanli.GeShou;
import mv.beanguanli.ShiPin;
import mv.beanguanli.YinYue;
import mv.beanyonhu.Huifu;
import mv.beanyonhu.YonHu;
import mv.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class YonhuGerenDao {


    public int yhfk(int id, String name, String tp, String fk) throws Exception {
        String sql = "insert into yonhufankui(id,name,tp,fk) values (?,?,?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1,id);
            pr.setString(2,name);
            pr.setString(3,tp);
            pr.setString(4,fk);

            int c = pr.executeUpdate();
            return c;
        }
    }

    public int getmylikeMount(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from mylikemisic where id = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public List<YinYue> yhlkyy(int id) throws Exception {
        List<YinYue> yinYues = new ArrayList<YinYue>();

        String sql = "select * from mylikemisic where id = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);

            try (ResultSet resultSet = pr.executeQuery()){
                while (resultSet.next()) {
                    int mid = resultSet.getInt(2);
                    String mname = resultSet.getString(3);
                    String mauthor = resultSet.getString(4);
                    String mtp = resultSet.getString(5);
                    int mlike = resultSet.getInt(6);
                    int mvip = resultSet.getInt(7);
                    String mlx = resultSet.getString(8);

                    YinYue yy = new YinYue(mid, mname, mauthor, mtp, mlike, mvip, mlx);
                    yinYues.add(yy);
                }
                return yinYues;
            }

        }

    }


    public int bjt(int id, String tp) throws Exception {
        String sql = "insert into mybjtp values(? ,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);
            pr.setString(2, tp);

            int c = pr.executeUpdate();
            return c;
        }
    }


    public String getmybjtp(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select top 1 bjtp from mybjtp where id = ? order by bjid desc";
            return (String) new QueryRunner().query(conn, sql, new ScalarHandler<>(),id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public int getmylikespMount(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from mylikevideo where id = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public List<ShiPin> yhlksp(int id) throws Exception {
        List<ShiPin> shiPins = new ArrayList<ShiPin>();
        String sql = "select * from mylikevideo where id = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);
            try (ResultSet re = pr.executeQuery()){
                while (re.next()) {
                    int vid = re.getInt(2);
                    String vname = re.getString(3);
                    String vauthor = re.getString(4);
                    int vlike = re.getInt(5);
                    int vvip = re.getInt(6);

                    ShiPin sp = new ShiPin(vid, vname, vauthor, vlike, vvip);
                    shiPins.add(sp);
                }
                return shiPins;
            }
        }
    }



    public List<Huifu> gethuifu(int id) throws Exception {
        List<Huifu> huifus = new ArrayList<Huifu>();
        String sql = "select * from huifu where id = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);
            try (ResultSet re = pr.executeQuery()){
                while (re.next()) {
                    int ids = re.getInt(1);
                    String hfs = re.getString(2);

                    Huifu hf = new Huifu(ids,hfs);
                    huifus.add(hf);
                }
                return huifus;
            }
        }
    }

    public int getmyhfMount(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from huifu where id = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }




    public int getmylikegsMount(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from mylikegeshou where id = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public List<GeShou> yhlkgs(int id) throws Exception {
        List<GeShou> geShous = new ArrayList<GeShou>();

        String sql = "select * from mylikegeshou where id = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);

            try (ResultSet resultSet = pr.executeQuery()){
                while (resultSet.next()) {
                    int pid = resultSet.getInt(2);
                    String pname = resultSet.getString(3);
                    String ptp = resultSet.getString(4);
                    int plike = resultSet.getInt(5);
                    String pjiesao = resultSet.getString(6);

                    GeShou gs = new GeShou(pid, pname, ptp, plike, pjiesao);
                    geShous.add(gs);
                }
                return geShous;
            }

        }

    }




}
