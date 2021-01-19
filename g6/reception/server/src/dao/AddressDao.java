package dao;

import bean.Address;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBHelper;

import java.sql.Connection;
import java.util.List;

public class AddressDao {
    /**
     * selectalladdress 查询所有收货人
     * addaddress 添加一个收货人
     * updateaddress 根据用户id更改收货人信息
     * deleteaddress 删除收货人
     *
     */
    public List<Address> selectalladdress() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from user_address";
        List<Address> addresses = null;
        try {
            QueryRunner runner = new QueryRunner();
            addresses = runner.query(connection, sql, new BeanListHandler<Address>(Address.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return addresses;
    }

    public List<Address> selectbyuserNoaddress(int userNo) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from user_address where userNo = ?";
        List<Address> addresses = null;
        try {
            QueryRunner runner = new QueryRunner();
            addresses = runner.query(connection, sql, new BeanListHandler<Address>(Address.class),userNo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return addresses;
    }

    public void addaddress(Address address) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "insert into user_address(userno,consignee,detail_address,tel) values(?,?,?,?)";
        try {
            Object[] object = {
                    address.getUserNo(),address.getConsignee(),address.getDetail_address(),address.getTel()
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

    public void updateaddress(Address address) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "update user_address set userno = ?,consignee = ?,detail_address = ?,tel = ? where userNo = ?";
        try {
            Object[] objects = {
                    address.getUserNo(),address.getConsignee(),address.getDetail_address(),address.getTel(),address.getUserNo()
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

    public void deleteaddress(Address address) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "delete from user_address where userNo = ?";
        try {
            Object[] objects = {
                    address.getUserNo()
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
