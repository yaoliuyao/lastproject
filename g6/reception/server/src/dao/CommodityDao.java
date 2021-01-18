package dao;

import bean.Commodity;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBHelper;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

public class CommodityDao {
    /**
     * selectallcommodities 查询所有图书商品
     * selectbybooknamecommoditie 根据图书名字查询图书
     * selectbyauthorcommoditie 根据图书作者查询图书
     * addcommoditie 添加一本图书
     * updatecommoditie 根据图书编号更改图书信息
     * deletecommoditie 根据图书编号删除图书
     */
    public List<Commodity> selectallcommodities() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_commodity";
        List<Commodity> commodities = null;
        try {
            QueryRunner runner = new QueryRunner();
            commodities = runner.query(connection, sql, new BeanListHandler<Commodity>(Commodity.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return commodities;
    }

    public List<Commodity> selectbybooknamebookcommoditie(String bookName,String author) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_commodity where bookName like ? or author like ?";
        List<Commodity> commodities = null;
        try {
            QueryRunner runner = new QueryRunner();
            commodities = runner.query(connection, sql, new BeanListHandler<Commodity>(Commodity.class),"%"+bookName+"%","%"+author+"%");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return commodities;
    }

    public List<Commodity> selectgirlcommoditie() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select top(2)* from book_commodity where typeNo = ?";
        List<Commodity> commodities = null;
        int random1 = (int)(8+Math.random()*(11-8+1));
        try {
            QueryRunner runner = new QueryRunner();
            commodities = runner.query(connection, sql, new BeanListHandler<Commodity>(Commodity.class),random1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return commodities;
    }

    public List<Commodity> selectboycommoditie() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select top(2)* from book_commodity where typeNo = ?";
        List<Commodity> commodities = null;
        int random1 = (int)(2+Math.random()*(7-2+1));
        try {
            QueryRunner runner = new QueryRunner();
            commodities = runner.query(connection, sql, new BeanListHandler<Commodity>(Commodity.class),random1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return commodities;
    }

    public int selectcproductNo() throws Exception{
        int productNo = 0;
        Connection connection = DBHelper.getConnection();
        String sql = "select count(productNo) as cproductNo from book_commodity";
        try {
            QueryRunner runner = new QueryRunner();
            productNo = runner.query(connection,sql, new ScalarHandler<Integer>());
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return productNo;
    }

    public List<Commodity> selectrandomcommoditie() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_commodity where productNo in (?,?)";
        List<Commodity> commodities = null;
        int count = new CommodityDao().selectcproductNo();
        Random random = new Random();
        int random1 = 0;
        int random2 = 0;
        for (int i = 0; i <= count; i++){
            random1 = random.nextInt(count);
            random2 = random.nextInt(count);
        }
        try {
            QueryRunner runner = new QueryRunner();
            commodities = runner.query(connection, sql, new BeanListHandler<Commodity>(Commodity.class),random1,random2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return commodities;
    }

    public List<Commodity> selectbestsellercommoditie() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select top(7)* from book_commodity where productNo between 2 and 10";
        List<Commodity> commodities = null;
        try {
            QueryRunner runner = new QueryRunner();
            commodities = runner.query(connection, sql, new BeanListHandler<Commodity>(Commodity.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return commodities;
    }

    public List<Commodity> selectbestsellercommoditie2() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select top(7)* from book_commodity where productNo between 11 and 20";
        List<Commodity> commodities = null;
        try {
            QueryRunner runner = new QueryRunner();
            commodities = runner.query(connection, sql, new BeanListHandler<Commodity>(Commodity.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return commodities;
    }

    public List<Commodity> selectbestsellercommoditie3() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select top(7)* from book_commodity where productNo between 21 and 30";
        List<Commodity> commodities = null;
        try {
            QueryRunner runner = new QueryRunner();
            commodities = runner.query(connection, sql, new BeanListHandler<Commodity>(Commodity.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return commodities;
    }

    public List<Commodity> selectbyauthorcommoditie(String author) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_commodity where author like ?";
        List<Commodity> commodities = null;
        try {
            QueryRunner runner = new QueryRunner();
            commodities = runner.query(connection, sql, new BeanListHandler<Commodity>(Commodity.class),"%"+author+"%");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return commodities;
    }

    public Commodity selectbyproductNocommoditie(Commodity commodity) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_commodity where productNo = ?";
        Commodity commodities = null;
        try {
            QueryRunner runner = new QueryRunner();
            commodities = runner.query(connection, sql, new BeanHandler<Commodity>(Commodity.class),commodity.getProductNo());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return commodities;
    }

    public void addcommoditie(Commodity commodity) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "insert into book_commodity(typeNo,rid,bookName,author,price,buyCount,stock,cover,content) values(?,?,?,?,?,?,?,?)";
        try {
            Object[] object = {
                    commodity.getTypeNo(), commodity.getRid(),commodity.getBookName(), commodity.getAuthor(), commodity.getPrice(), commodity.getBuyCount(), commodity.getStock(), commodity.getCover(), commodity.getContent()
            };
            QueryRunner runner = new QueryRunner();
            runner.update(connection,sql,object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
    }

    public void updatecommoditie(Commodity commodity) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "update book_commodity set typeNo = ?,rid = ?bookName = ?,author = ?,price = ?,buyCount = ?,stock = ?,cover = ?,content = ?,state = ? where productNo = ?";
        try {
            Object[] objects = {
                    commodity.getTypeNo(), commodity.getRid(),commodity.getBookName(), commodity.getAuthor(), commodity.getPrice(), commodity.getBuyCount(), commodity.getStock(), commodity.getCover(), commodity.getContent(), commodity.getProductNo(),commodity.getState()
            };
            QueryRunner queryRunner = new QueryRunner();
            queryRunner.update(connection,sql,objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
    }

    public void deletecommoditie(Commodity commodity) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "delete from book_commodity where productNo = ?";
        try {
            Object[] objects = {
                    commodity.getProductNo()
            };
            QueryRunner queryRunner = new QueryRunner();
            queryRunner.update(connection,sql,objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
    }
}
