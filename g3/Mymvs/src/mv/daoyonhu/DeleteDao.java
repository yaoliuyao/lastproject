package mv.daoyonhu;

import mv.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

public class DeleteDao {

    public void yhdeleteyy(String mid,String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from mylikemisic where mid = ? and id = ?";
        try {
            new QueryRunner().update(conn, sql, mid , id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void yhdeletesp(String vid,String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from mylikevideo where vid = ? and id = ?";
        try {
            new QueryRunner().update(conn, sql, vid , id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void yhdeletehf(String id,String hf) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from huifu where id = ? and hf= ?";
        try {
            new QueryRunner().update(conn, sql, id , hf);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void yhdeletegs(String pid,String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from mylikegeshou where pid = ? and id = ?";
        try {
            new QueryRunner().update(conn, sql, pid , id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

<<<<<<< HEAD
    public void yhdeleteyypl(String mcid,String yhid) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from misicComment where mcid = ? and yhid = ?";
        try {
            new QueryRunner().update(conn, sql, mcid , yhid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    public void yhdeletesppl(String vcid,String yhid) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from videoComment where vcid = ? and yhid = ?";
        try {
            new QueryRunner().update(conn, sql, vcid , yhid);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    public void yhdeletejg(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from jiangao where id = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

=======
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa
}
