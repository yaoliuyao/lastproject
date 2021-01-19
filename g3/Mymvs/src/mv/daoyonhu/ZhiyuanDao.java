package mv.daoyonhu;

import mv.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ZhiyuanDao {

    public int addmylikeyy(int id,int mid,String mname,String mauthor,String mtp,int mlike,int mvip,String mlx) throws Exception {
        String sql = "insert into mylikemisic values(?,?,?,?,?,?,?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
             pr.setInt(1,id);
             pr.setInt(2,mid);
             pr.setString(3,mname);
             pr.setString(4,mauthor);
             pr.setString(5,mtp);
             pr.setInt(6,mlike);
             pr.setInt(7,mvip);
             pr.setString(8,mlx);

            int c = pr.executeUpdate();
            return c;
        }
    }

    public int getlikeyyMount(int mid) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from mylikemisic where mid = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),mid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public int addmylikesp(int id,int vid,String vname,String vauthor,int vlike,int vvip) throws Exception {
        String sql = "insert into mylikevideo values(?,?,?,?,?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1,id);
            pr.setInt(2,vid);
            pr.setString(3,vname);
            pr.setString(4,vauthor);
            pr.setInt(5,vlike);
            pr.setInt(6,vvip);

            int c = pr.executeUpdate();
            return c;
        }
    }

    public int getlikespMount(int vid) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from mylikevideo where vid = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),vid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }



    public int getgsyy(String name) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic where mauthor = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),name);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    public int getgssp(String name) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from video where vauthor = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),name);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public int addmylikegs(int id,int pid,String pname,String ptp,int plike,String pjiesao) throws Exception {
        String sql = "insert into mylikegeshou values(?,?,?,?,?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1,id);
            pr.setInt(2,pid);
            pr.setString(3,pname);
            pr.setString(4,ptp);
            pr.setInt(5,plike);
            pr.setString(6,pjiesao);

            int c = pr.executeUpdate();
            return c;
        }
    }


    public int getlikegsMount(int pid) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from mylikegeshou where pid = ?";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>(),pid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public void dzyy(int mid) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update misic set mlike = mlike + 1 where mid = ?";
        try {
            new QueryRunner().update(conn, sql, mid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
//    public int dzyy(int mid) throws Exception {
//        Connection conn = DBHelper.getConnection();
//        try {
//            String sql = "update misic set mlike = mlike + 1 where mid = ?";
//            return (int) new QueryRunner().update(conn, sql, new ScalarHandler<>(),mid);
//        } finally {
//            DbUtils.closeQuietly(conn);
//        }
//    }

    public void dzsp(int vid) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update video set vlike = vlike + 1 where vid = ?";
        try {
            new QueryRunner().update(conn, sql, vid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void dzgs(int pid) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update player set plike = plike + 1 where pid = ?";
        try {
            new QueryRunner().update(conn, sql, pid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public void dzyypl(int mcid) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update misicComment set mclike = mclike + 1 where mcid = ?";
        try {
            new QueryRunner().update(conn, sql, mcid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void dzsppl(int vcid) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update videoComment set vclike = vclike + 1 where vcid = ?";
        try {
            new QueryRunner().update(conn, sql, vcid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }



}
