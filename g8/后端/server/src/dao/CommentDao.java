package dao;


import DB.DBhelp;
import bean.Comment;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

//评论
public class CommentDao {
    //发表评论
    public Comment addComments(Comment comment) throws Exception {
        Connection conn = DBhelp.getConnection();
        String sql = "insert into commentInfo values(?,?,?,?,?,?)";

        try {
            QueryRunner run = new QueryRunner();
            Object[] params = {comment.getContent(), comment.getLike(), comment.getId(),
                    comment.getUsername(), comment.getTime()};
            run.update(conn, sql, params);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return comment;
    }

    //删除评论
    public int delComment(int id) throws Exception {
        Connection conn = DBhelp.getConnection();
        String sql = "delete from commentInfo where cid =?";

        try {
            new QueryRunner().update(conn,sql,id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return id;
    }

    //加载所有的评论
    public List<Comment> getAllComments() throws Exception {
        Connection conn = DBhelp.getConnection();
        String sql = "select * from commentInfo";

        try {
            return new QueryRunner()
                    .query(conn,sql,new BeanListHandler<Comment>(Comment.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
