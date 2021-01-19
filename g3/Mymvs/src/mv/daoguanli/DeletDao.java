package mv.daoguanli;

import mv.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

public class DeletDao {

    public void deletesp(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from video where vid = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void deleteyy(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from misic where mid = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void deletegs(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from player where pid = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void deleteyh(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from yonhu where id = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void deletefk(String fk) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from yonhufankui where fk = ?";
        try {
            new QueryRunner().update(conn, sql, fk);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


}
