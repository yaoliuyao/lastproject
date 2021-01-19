package mv.daoguanli;

import mv.beanguanli.FanKui;
import mv.beanguanli.GeShou;
import mv.beanguanli.ShiPin;
import mv.beanguanli.YinYue;
import mv.beanyonhu.YonHu;
import mv.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LookDao {

    public List<ShiPin> shiPins(int currentPage, int limit) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from " +
                "(select row_number() over (order by vid desc) as rn, " +
                "vid, vname, vauthor, vlike, vvip from video) as s " +
                "where rn between ? and ?";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<ShiPin>(ShiPin.class),
                    (currentPage - 1) * limit + 1,
                    currentPage * limit);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getShipinsMount() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from video";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public List<ShiPin> likesp(String ss) throws Exception {
        List<ShiPin> shiPins = new ArrayList<ShiPin>();

        String sql = "select * from video where vname like ? or vauthor like ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, "%"+ss+"%");
            pr.setString(2, "%"+ss+"%");

            try (ResultSet resultSet = pr.executeQuery()){
                while (resultSet.next()) {
                    int vid = resultSet.getInt(1);
                    String vname = resultSet.getString(2);
                    String vauthor = resultSet.getString(3);
                    int vlike = resultSet.getInt(4);
                    int vvip = resultSet.getInt(5);

                    ShiPin sp = new ShiPin(vid, vname, vauthor, vlike, vvip);
                    shiPins.add(sp);
                }
                return shiPins;
            }

        }

    }

//    -----------------------------------------------------------------------------
//    -----------------------------------------------------------------------------
//    -----------------------------------------------------------------------------

    public List<YinYue> yinYues(int currentPage, int limit) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from " +
                "(select row_number() over (order by mid desc) as rn, " +
                "mid, mname, mauthor, mtp, mlike, mvip, mlx from misic) as s " +
                "where rn between ? and ?";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<YinYue>(YinYue.class),
                    (currentPage - 1) * limit + 1,
                    currentPage * limit);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getYinyueMount() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }



    public List<YinYue> like(String ss) throws Exception {
        List<YinYue> yinYues = new ArrayList<YinYue>();

        String sql = "select * from misic where mname like ? or mauthor like ? or mlx like ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, "%"+ss+"%");
            pr.setString(2, "%"+ss+"%");
            pr.setString(3, "%"+ss+"%");

            try (ResultSet resultSet = pr.executeQuery()){
                while (resultSet.next()) {
                    int mid = resultSet.getInt(1);
                    String mname = resultSet.getString(2);
                    String mauthor = resultSet.getString(3);
                    String mtp = resultSet.getString(4);
                    int mlike = resultSet.getInt(5);
                    int mvip = resultSet.getInt(6);
                    String mlx = resultSet.getString(7);

                    YinYue yy = new YinYue(mid, mname, mauthor, mtp, mlike, mvip, mlx);
                    yinYues.add(yy);
                }
                return yinYues;
            }

        }

    }


    //    -----------------------------------------------------------------------------
//    -----------------------------------------------------------------------------
//    -----------------------------------------------------------------------------

    public List<GeShou> gesou(int currentPage, int limit) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from " +
                "(select row_number() over (order by pid desc) as rn, " +
                "pid, pname, ptp, plike, pjiesao from player) as s " +
                "where rn between ? and ?";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<GeShou>(GeShou.class),
                    (currentPage - 1) * limit + 1,
                    currentPage * limit);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getgesouMount() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from player";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public List<GeShou> likegs(String ss) throws Exception {
        List<GeShou> geShous = new ArrayList<GeShou>();

        String sql = "select * from player where pname like ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, "%"+ss+"%");

            try (ResultSet resultSet = pr.executeQuery()){
                while (resultSet.next()) {
                    int pid = resultSet.getInt(1);
                    String pname = resultSet.getString(2);
                    String ptp = resultSet.getString(3);
                    int plike = resultSet.getInt(4);
                    String pjiesao = resultSet.getString(5);

                    GeShou gs = new GeShou(pid, pname, ptp, plike, pjiesao);
                    geShous.add(gs);
                }
                return geShous;
            }

        }

    }


    //    -----------------------------------------------------------------------------
//    -----------------------------------------------------------------------------
//    -----------------------------------------------------------------------------

    public List<YonHu> yonhu(int currentPage, int limit) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from " +
                "(select row_number() over (order by id desc) as rn, " +
                "id, name, pwd, tp, vip, viptime1, viptime2, viptime3, time from yonhu) as s " +
                "where rn between ? and ?";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<YonHu>(YonHu.class),
                    (currentPage - 1) * limit + 1,
                    currentPage * limit);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getyonhuMount() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from yonhu";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public List<YonHu> likeyh(String ss) throws Exception {
        List<YonHu> yonHus = new ArrayList<YonHu>();

        String sql = "select * from yonhu where name like ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, "%"+ss+"%");

            try (ResultSet resultSet = pr.executeQuery()){
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String pwd = resultSet.getString(3);
                    String tp = resultSet.getString(4);
                    int vip = resultSet.getInt(5);
                    int viptime1 = resultSet.getInt(6);
                    int viptime2 = resultSet.getInt(7);
                    int viptime3 = resultSet.getInt(8);
                    Date time = resultSet.getDate(9);

                    YonHu yh = new YonHu(id, name, pwd, tp, vip, viptime1, viptime2, viptime3, time);
                    yonHus.add(yh);
                }
                return yonHus;
            }

        }

    }


    //    -----------------------------------------------------------------------------
//    -----------------------------------------------------------------------------
//    -----------------------------------------------------------------------------

    public List<FanKui> fanKuis(int currentPage, int limit) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from " +
<<<<<<< HEAD
                "(select row_number() over (order by fkid desc) as rn, " +
                "fkid, id, name, tp, fk, time, sf from yonhufankui) as s " +
=======
                "(select row_number() over (order by time desc) as rn, " +
                "id, name, tp, fk, time, sf from yonhufankui) as s " +
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa
                "where rn between ? and ?";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<FanKui>(FanKui.class),
                    (currentPage - 1) * limit + 1,
                    currentPage * limit);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getfkMount() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from yonhufankui";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void bian(String fk) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update yonhufankui set sf = 1 where fk = ?";
        try {
            new QueryRunner().update(conn, sql, fk);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


}
