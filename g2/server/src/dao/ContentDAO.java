package dao;

import bean.Content;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utile.DBHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class ContentDAO {
/* 查询所有内容*/
    public List<Content> getCommentsByPostId() throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select *from content";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<Content>(Content.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    /* 点赞方法*/
    public int like(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "update content set likeit = likeit + 1 where id = ?";
        try {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, id);
            sql = "select likeit from content where id = ?";
            return (int) runner.query(conn, sql, new ScalarHandler<>(), id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    /*添加内容*/
    public Content addComment(Content content) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into content(id , title, contents) values(?, ?, ?)";
        Object[] params = {
                    content.getId(),content.getTitle(),content.getContents()
        };
        try {
            // 添加的第三个参数，表名需要返回一个 Long 类型的主键
            // 所以，它返回的就是主键
            QueryRunner runner = new QueryRunner();
            BigDecimal res = runner.insert(conn, sql, new ScalarHandler<BigDecimal>(), params);
            sql = "select * from content where id = ?";
            return runner.query(conn, sql, new BeanHandler<>(Content.class), res.longValue());
        } finally {
            // 千万不要忘记关闭
            // 要放到 finally 里，因为 finally 的语句不管有没有异常都会被执行
            DbUtils.closeQuietly(conn);
        }
    }
    /*删除内容*/
    public void delete(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from content where id = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
