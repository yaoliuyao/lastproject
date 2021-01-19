package dao;


import DB.DBhelp;
import bean.Post;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

//文章
public class PostDao {
    //添加文章
    public Post addPosts(Post post) throws Exception {
        Connection conn = DBhelp.getConnection();
        String sql = "insert into postInfo values(?,?,?,?,?,?)";
        try {
            QueryRunner qr = new QueryRunner();
            Object[] objects = {post.getContents(),post.getFace()
            ,post.getLike(),post.getTime(),post.getTitle(),post.getUsername()};
            qr.update(conn,sql,qr);
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return post;
    }

    //删除文章
    public int delPost(int id) throws Exception {
        Connection conn = DBhelp.getConnection();
        String sql = "delete from postInfo where aid =?";

        try {
            new QueryRunner().update(conn,sql,id);
        } finally {
            DbUtils.closeQuietly(conn);
        }

        return id;
    }

    //所有文章
    public List<Post> getAllPosts() throws Exception {
        Connection conn = DBhelp.getConnection();
        String sql = "select * from postInfo";

        try {
            return new QueryRunner()
                    .query(conn,sql,new BeanListHandler<Post>(Post.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    //加载热门文章
    public List<Post> getHotPost() throws Exception {
        Connection conn = DBhelp.getConnection();
        String sql ="select * from postInfo order by like desc";

        try {
            return new QueryRunner()
                    .query(conn,sql,new BeanListHandler<Post>(Post.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
