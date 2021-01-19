package mv.daoyonhu;

import mv.beanguanli.FanKui;
import mv.beanguanli.GeShou;
import mv.beanguanli.ShiPin;
import mv.beanguanli.YinYue;
import mv.beanyonhu.*;
import mv.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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


    public List<LikeYinYue> yhlkyy(int id) throws Exception {
        List<LikeYinYue> yinYues = new ArrayList<LikeYinYue>();

        String sql = "select * from mylikemisic where id = ?  order by xhid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);

            try (ResultSet resultSet = pr.executeQuery()){
                while (resultSet.next()) {
                    int xhid = resultSet.getInt(1);
                    int mid = resultSet.getInt(3);
                    String mname = resultSet.getString(4);
                    String mauthor = resultSet.getString(5);
                    String mtp = resultSet.getString(6);
                    int mlike = resultSet.getInt(7);
                    int mvip = resultSet.getInt(8);
                    String mlx = resultSet.getString(9);

                    LikeYinYue yy = new LikeYinYue(xhid, mid, mname, mauthor, mtp, mlike, mvip, mlx);
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

    public List<LikeShiPin> yhlksp(int id) throws Exception {
        List<LikeShiPin> shiPins = new ArrayList<LikeShiPin>();
        String sql = "select * from mylikevideo where id = ?  order by xhid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);
            try (ResultSet re = pr.executeQuery()){
                while (re.next()) {
                    int xhid = re.getInt(1);
                    int vid = re.getInt(3);
                    String vname = re.getString(4);
                    String vauthor = re.getString(5);
                    int vlike = re.getInt(6);
                    int vvip = re.getInt(7);

                    LikeShiPin sp = new LikeShiPin(xhid, vid, vname, vauthor, vlike, vvip);
                    shiPins.add(sp);
                }
                return shiPins;
            }
        }
    }



    public List<Huifu> gethuifu(int id) throws Exception {
        List<Huifu> huifus = new ArrayList<Huifu>();
        String sql = "select * from huifu where id = ?  order by hfid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);
            try (ResultSet re = pr.executeQuery()){
                while (re.next()) {
                    int hfids = re.getInt(1);
                    int ids = re.getInt(2);
                    String hfs = re.getString(3);

                    Huifu hf = new Huifu(hfids,ids,hfs);
                    huifus.add(hf);
                }
                return huifus;
            }
        }
    }
    public List<FanKui> getmyfk(int id) throws Exception {
        List<FanKui> fanKuis = new ArrayList<FanKui>();
        String sql = "select * from yonhufankui where id = ? and sf = 1 order by fkid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);
            try (ResultSet re = pr.executeQuery()){
                while (re.next()) {
                    int fkid = re.getInt(1);
                    int ids = re.getInt(2);
                    String name = re.getString(3);
                    String tp = re.getString(4);
                    String fks = re.getString(5);
                    Date time = re.getDate(6);
                    int sf = re.getInt(7);

                    FanKui fk = new FanKui(fkid,ids,name,tp,fks,time,sf);
                    fanKuis.add(fk);
                }
                return fanKuis;
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


    public List<LikeGeShou> yhlkgs(int id) throws Exception {
        List<LikeGeShou> geShous = new ArrayList<LikeGeShou>();

        String sql = "select * from mylikegeshou where id = ? order by xhid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);

            try (ResultSet resultSet = pr.executeQuery()){
                while (resultSet.next()) {
                    int xhid = resultSet.getInt(1);
                    int pid = resultSet.getInt(3);
                    String pname = resultSet.getString(4);
                    String ptp = resultSet.getString(5);
                    int plike = resultSet.getInt(6);
                    String pjiesao = resultSet.getString(7);

                    LikeGeShou gs = new LikeGeShou(xhid, pid, pname, ptp, plike, pjiesao);
                    geShous.add(gs);
                }
                return geShous;
            }

        }

    }


    public List<Pinlunyy> yhplyy(int id) throws Exception {
        List<Pinlunyy> geShous = new ArrayList<Pinlunyy>();

        String sql = "select * from misicComment where yhid = ? order by mcid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);

            try (ResultSet resultSet = pr.executeQuery()){
                while (resultSet.next()) {
                    int mcid = resultSet.getInt(1);
                    int mid = resultSet.getInt(2);
                    String mComment = resultSet.getString(3);
                    Date mtime = resultSet.getDate(4);
                    int yhid = resultSet.getInt(5);
                    int mclike = resultSet.getInt(6);
                    String yhname = resultSet.getString(7);
                    String yhtx = resultSet.getString(8);

                    Pinlunyy gs = new Pinlunyy(mcid, mid, mComment, mtime, yhid, mclike, yhname, yhtx);
                    geShous.add(gs);
                }
                return geShous;
            }

        }

    }


    public List<Pinlunsp> yhplsp(int id) throws Exception {
        List<Pinlunsp> geShous = new ArrayList<Pinlunsp>();

        String sql = "select * from videoComment where yhid = ? order by vcid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);

            try (ResultSet resultSet = pr.executeQuery()){
                while (resultSet.next()) {
                    int vcid = resultSet.getInt(1);
                    int vid = resultSet.getInt(2);
                    String vComment = resultSet.getString(3);
                    Date vtime = resultSet.getDate(4);
                    int yhid = resultSet.getInt(5);
                    int vclike = resultSet.getInt(6);
                    String yhname = resultSet.getString(7);
                    String yhtx = resultSet.getString(8);

                    Pinlunsp gs = new Pinlunsp(vcid, vid, vComment, vtime, yhid, vclike, yhname, yhtx);
                    geShous.add(gs);
                }
                return geShous;
            }

        }

    }

    public int getmyyyplMount(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misicComment where yhid = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    public int getmyspplMount(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from videoComment where yhid = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }



}
