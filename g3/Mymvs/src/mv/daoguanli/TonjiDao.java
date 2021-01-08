package mv.daoguanli;

import mv.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;

public class TonjiDao {

    public int getgesouguoyu() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic where mlx like '%国语%'";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getgesouwaiyu() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic where mlx like '%外语%'";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getgesouyyu() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic where mlx like '%粤语%'";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getgesouliuxin() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic where mlx like '%流行%'";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getgesouminyao() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic where mlx like '%民谣%'";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getgesouqin() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic where mlx like '%轻音乐%'";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getgesougufen() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic where mlx like '%古风%'";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getgesousan() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic where mlx like '%伤感%'";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getgesoudj() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic where mlx like '%DJ%'";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int getgesouanjin() throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            String sql = "select count(*) from misic where mlx like '%安静%'";
            return (int) new QueryRunner().query(conn, sql, new ScalarHandler<>());
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

}
