package dao;

import bean.Order;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBHelper;

import java.sql.Connection;
import java.util.List;

public class OrderDao {
    /**
     * selectallorders 查询所有订单
     * addorder 添加订单
     * updateorder 更改订单
     * deletorder 删除订单
     *
     */
    public List<Order> selectallorders() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_order";
        List<Order> orders = null;
        try {
            QueryRunner runner = new QueryRunner();
            orders = runner.query(connection, sql, new BeanListHandler<Order>(Order.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return orders;
    }
    public List<Order> selectbyuserNoorder(int userNo) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_order where userNo = ?";
        List<Order> orders = null;
        try {
            QueryRunner runner = new QueryRunner();
            orders = runner.query(connection, sql, new BeanListHandler<Order>(Order.class),userNo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return orders;
    }

    public void addorder(Order order) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "insert into book_order(userno,productNo,addressNo,payment_number,productnum,amount,remarks) values(?,?,?,?,?,?,?)";
        try {
            Object[] object = {
                    order.getUserNo(),order.getProductNo(),order.getAddressNo(),order.getPayment_number(),order.getProductnum(),order.getAmount(),order.getRemarks()
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

    public void updateorder(Order order) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "update book_order set status = ? where userNo = ?";
        try {
            Object[] objects = {
                    order.getStatus(),order.getUserNo()
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

    public void deletorder(Order order) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "delete from book_order where userNo = ?";
        try {
            Object[] objects = {
                    order.getUserNo()
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
