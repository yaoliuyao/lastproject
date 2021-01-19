package dao;


import bean.Address;
import bean.Cart;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBHelper;

import java.sql.Connection;
import java.util.List;

public class CartDao {
    /**
     * selectallcarts 查询所有购物车
     * addcart 添加一个购物车
     * deletecart 删除购物车
     *
     */
    public List<Cart> selectallcarts() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_cart";
        List<Cart> carts = null;
        try {
            QueryRunner runner = new QueryRunner();
            carts = runner.query(connection, sql, new BeanListHandler<Cart>(Cart.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return carts;
    }
    public List<Cart> selectbyuserNo(int userNo) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_cart where userNo = ?";
        List<Cart> carts = null;
        try {
            QueryRunner runner = new QueryRunner();
            carts = runner.query(connection, sql, new BeanListHandler<Cart>(Cart.class),userNo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return carts;
    }

    public void addcart(Cart cart) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "insert into book_cart(productNo,userNo,booknum,cprice) values(?,?,?,?)";
        try {
            Object[] object = {
                    cart.getProductNo(),cart.getUserNo(),cart.getBooknum(),cart.getCprice()
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

    public void deletecart(Cart cart) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "delete from book_cart where userNo = ?";
        try {
            Object[] objects = {
                    cart.getUserNo()
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
