package DAO;

import bean.Articles;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import sun.text.resources.FormatData;
import utils.DBhelper;

import java.sql.Connection;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ArticlesDAO {
    public Articles AddArticles(Articles articles) throws Exception{ /*发表文章*/
        Connection conn = DBhelper.getConnection();
        String sql = "insert into Articles values (?,?,?,?,?,?)";
        try {
            QueryRunner runner = new QueryRunner();
            Object[] objects = {

                    articles.getUserid(),
                    articles.getAname(),
                    articles.getAcontent(),
                    articles.getAgood(),
                    articles.getAlook()
            };
            runner.update(conn, sql, objects);
        }finally {
            DbUtils.closeQuietly(conn);
        }
        return articles;
    }
    public void deleteArticles(int Aid) throws Exception{
        Connection conn = DBhelper.getConnection();
        String sql = "delete from Articles where Aid = ?";
        try {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, Aid);
        }finally {
            DbUtils.closeQuietly(conn);
        }
    }
    public int like(String id) throws Exception {
        Connection conn = DBhelper.getConnection();
        String sql = "update Articles set Agood = Agood + 1 where Aid = ?";
        try {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, id);
            sql = "select Agood from Articles where Aid = ?";
            /*try {
                sql = "insert into Collent values(?,?) where Aid = id ";

            }finally {

            }*/
            return (int) runner.query(conn, sql, new ScalarHandler<>(), id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    public List<Articles> List() throws Exception{
        Connection conn = DBhelper.getConnection();
        String sql = "select * from Articles";
        try {
            return new QueryRunner().query(conn, sql, new BeanListHandler<Articles>(Articles.class));

        }finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int Look(String id) throws Exception {
        Connection conn = DBhelper.getConnection();
        String sql = "update Articles set Alook = Alook + 1 where Aid = ?";
        try {
            QueryRunner runner = new QueryRunner();
            runner.update(conn, sql, id);
            sql = "select Alook from Articles where Aid = ?";
            return (int) runner.query(conn, sql, new ScalarHandler<>(), id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public List<Articles> list() throws Exception{
        Connection conn = DBhelper.getConnection();
        String sql = "select * from Articles order by Alook desc ";
        try {
            return new QueryRunner().query(conn, sql, new BeanListHandler<Articles>(Articles.class));

        }finally {
            DbUtils.closeQuietly(conn);
        }
    }
    public List<Articles> Top() throws Exception{
        Connection conn = DBhelper.getConnection();
        String sql = "select * from Articles order by Agood desc ";
        try {
            return new QueryRunner().query(conn, sql, new BeanListHandler<Articles>(Articles.class));

        }finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
