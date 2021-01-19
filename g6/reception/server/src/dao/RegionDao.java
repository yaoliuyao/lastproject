package dao;

import bean.Region;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBHelper;

import java.sql.Connection;
import java.util.List;

public class RegionDao {
    /**
     * selectallregions 查询所有图书地区种类
     * addregion 添加图书地区种类
     * updateregion 更改地区名字
     * deleteregion 删除地区图书地区种类
     *
     */
    public List<Region> selectallregions() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_region";
        List<Region> regions = null;
        try {
            QueryRunner runner = new QueryRunner();
            regions = runner.query(connection, sql, new BeanListHandler<Region>(Region.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return regions;
    }

    public void addregion(Region region) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "insert into book_region(region) values(?)";
        try {
            Object[] object = {
                    region.getRegion()
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

    public void updateregion(Region region) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "update book_region set region = ? where rid = ?";
        try {
            Object[] objects = {
                    region.getRegion(),region.getRid()
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

    public void deleteregion(Region region) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "delete from book_region where rid = ?";
        try {
            Object[] objects = {
                    region.getRid()
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
