package mv.daoyonhu;

import mv.beanguanli.FanKui;
import mv.beanguanli.GeShou;
import mv.beanguanli.ShiPin;
import mv.beanguanli.YinYue;
import mv.beanyonhu.Pinlunsp;
import mv.beanyonhu.Pinlunyy;
import mv.beanyonhu.YonHu;
import mv.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YonhuZhuyeiDao {


    public List<YinYue> yinyue() throws Exception {
        List<YinYue> yinYues = new ArrayList<YinYue>();

        String sql = "select top 10 * from misic order by mid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql);
             ResultSet resultSet = pr.executeQuery()){
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


    public List<YinYue> yinyuelunbuo() throws Exception {
        List<YinYue> yinYues = new ArrayList<YinYue>();

        String sql = "select top 5 * from misic order by mlike desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql);
             ResultSet resultSet = pr.executeQuery()){
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


//    public YinYue dayy(int id) throws Exception {
//        Connection conn = DBHelper.getConnection();
//        String sql = "select * from misic where mid = ?";
//        try {
//            return new QueryRunner().query(
//                    conn, sql, new BeanHandler<YinYue>(YinYue.class), id);
//        } finally {
//            DbUtils.closeQuietly(conn);
//        }
//    }                         以上方法为经典错误，百度解释看不懂，，，，当转化成以下又可以成功
    public YinYue dayy(int id) throws Exception {
        String sql = "select * from misic where mid = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);
            try (ResultSet re = pr.executeQuery()){
                re.next();
                YinYue yinYue = new YinYue(
                        re.getInt(1),
                        re.getString(2),
                        re.getString(3),
                        re.getString(4),
                        re.getInt(5),
                        re.getInt(6),
                        re.getString(7));
                return yinYue;
            }
        }

    }


    public int addpl(int yyid,String pl,int yhid,String yhname,String yhtx) throws Exception {
        String sql = "insert into misicComment(mid,mComment,yhid,yhname,yhtx) values(?, ?, ?, ?, ?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, yyid);
            pr.setString(2, pl);
            pr.setInt(3, yhid);
            pr.setString(4, yhname);
            pr.setString(5, yhtx);

            int c = pr.executeUpdate();
            return c;
        }
    }


    public List<Pinlunyy> pinlunyys(int mid, int currentPage, int limit) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from " +
                "(select row_number() over (order by mcid desc) as rn, " +
                "mcid, mid, mComment, mtime, yhid, mclike, yhname, yhtx from misicComment where mid = '"+mid+"') as s " +
                "where rn between ? and ?";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<Pinlunyy>(Pinlunyy.class),
                    (currentPage - 1) * limit + 1,
                    currentPage * limit);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getplMount(int mid) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misicComment where mid = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),mid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }




    public List<ShiPin> shiPins() throws Exception {
        List<ShiPin> yinYues = new ArrayList<ShiPin>();

        String sql = "select top 10 * from video order by vid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql);
             ResultSet resultSet = pr.executeQuery()){
            while (resultSet.next()) {
                int vid = resultSet.getInt(1);
                String vname = resultSet.getString(2);
                String vauthor = resultSet.getString(3);
                int vlike = resultSet.getInt(4);
                int vvip = resultSet.getInt(5);

                ShiPin sp = new ShiPin(vid, vname, vauthor, vlike, vvip);
                yinYues.add(sp);
            }
            return yinYues;
        }
    }

    public ShiPin dasp(int id) throws Exception {
        String sql = "select * from video where vid = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);
            try (ResultSet re = pr.executeQuery()){
                re.next();
                ShiPin shiPin = new ShiPin(
                        re.getInt(1),
                        re.getString(2),
                        re.getString(3),
                        re.getInt(4),
                        re.getInt(5));
                return shiPin;
            }
        }
    }

    public int addsppl(int spid,String pl,int yhid,String yhname,String yhtx) throws Exception {
        String sql = "insert into videoComment(vid,vComment,yhid,yhname,yhtx) values(?, ?, ?, ?, ?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, spid);
            pr.setString(2, pl);
            pr.setInt(3, yhid);
            pr.setString(4, yhname);
            pr.setString(5, yhtx);

            int c = pr.executeUpdate();
            return c;
        }
    }


    public List<Pinlunsp> pinlunsps(int vid, int currentPage, int limit) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from " +
                "(select row_number() over (order by vcid desc) as rn, " +
                "vcid, vid, vComment, vtime, yhid, vclike, yhname, yhtx from videoComment where vid = '"+vid+"') as s " +
                "where rn between ? and ?";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<Pinlunsp>(Pinlunsp.class),
                    (currentPage - 1) * limit + 1,
                    currentPage * limit);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getplspMount(int vid) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from videoComment where vid = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),vid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public List<ShiPin> qianwusp(String name) throws Exception {
        List<ShiPin> shiPins = new ArrayList<ShiPin>();
        String sql = "select top 5 * from video where vauthor = ? order by vid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, name);
            try (ResultSet re = pr.executeQuery()){
                while (re.next()) {
                    int vid = re.getInt(1);
                    String vname = re.getString(2);
                    String vauthor = re.getString(3);
                    int vlike = re.getInt(4);
                    int vvip = re.getInt(5);

                    ShiPin sp = new ShiPin(vid, vname, vauthor, vlike, vvip);
                    shiPins.add(sp);
                }
                return shiPins;
            }
        }
    }




    public List<YinYue> paihanbanone() throws Exception {
        List<YinYue> yinYues = new ArrayList<YinYue>();

        String sql = "select top 5 * from misic order by mlike desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql);
             ResultSet resultSet = pr.executeQuery()){
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
    public List<YinYue> paihanbantwo() throws Exception {
        List<YinYue> yinYues = new ArrayList<YinYue>();

        String sql = "select top 5 * from misic order by mid desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql);
             ResultSet resultSet = pr.executeQuery()){
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
    public List<YinYue> paihanbanthree() throws Exception {
        List<YinYue> yinYues = new ArrayList<YinYue>();

        String sql = "select top 5 * from misic where mlx like '%流行%' order by mlike desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql);
             ResultSet resultSet = pr.executeQuery()){
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
    public List<YinYue> paihanbanfour() throws Exception {
        List<YinYue> yinYues = new ArrayList<YinYue>();

        String sql = "select top 5 * from misic where mlx like '%粤语%' order by mlike desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql);
             ResultSet resultSet = pr.executeQuery()){
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
    public List<ShiPin> paihanbanwu() throws Exception {
        List<ShiPin> shiPins = new ArrayList<ShiPin>();

        String sql = "select top 5 * from video order by vlike desc";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql);
             ResultSet resultSet = pr.executeQuery()){
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



    public GeShou dags(int id) throws Exception {
        String sql = "select * from player where pid = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);
            try (ResultSet re = pr.executeQuery()){
                re.next();
                GeShou geShou = new GeShou(
                        re.getInt(1),
                        re.getString(2),
                        re.getString(3),
                        re.getInt(4),
                        re.getString(5));
                return geShou;
            }
        }

    }


    public List<YinYue> gsisyy(String name) throws Exception {
        List<YinYue> yinYues = new ArrayList<YinYue>();

        String sql = "select * from misic where mauthor = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, name);

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


    public List<ShiPin> gsissp(String name) throws Exception {
        List<ShiPin> shiPins = new ArrayList<ShiPin>();

        String sql = "select * from video where vauthor = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, name);

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





}
