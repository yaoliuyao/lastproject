package dao;

import bean.Content;
import bean.Details;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utile.DBHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class DetailsDAO {
    /*查询所有评论*/
    public List<Details> getCommentsByPostId() throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select id, content, author, created from comment  ";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<Details>(Details.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    /*添加评论*/
    public Details addComment(Details details) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into details(id,connents) values(?, ?, ?)";
        Object[] params = {
                details.getId(),details.getContent()
        };
        try {
            // 添加的第三个参数，表名需要返回一个 Long 类型的主键
            // 所以，它返回的就是主键
            QueryRunner runner = new QueryRunner();
            BigDecimal res = runner.insert(conn, sql, new ScalarHandler<BigDecimal>(), params);
            sql = "select * from details where id = ?";
            return runner.query(conn, sql, new BeanHandler<>(Details.class), res.longValue());
        } finally {
            // 千万不要忘记关闭
            // 要放到 finally 里，因为 finally 的语句不管有没有异常都会被执行
            DbUtils.closeQuietly(conn);
        }
    }
    /*删除评论*/
    public void delete(int id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from details where id = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
