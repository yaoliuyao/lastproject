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

}
