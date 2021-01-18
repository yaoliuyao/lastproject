package dao;

import bean.Classification;
import bean.Commodity;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBHelper;

import java.sql.Connection;
import java.util.List;

public class ClassificationDao {
    public List<Classification> selectallclassification() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_classification";
        List<Classification> classifications = null;
        try {
            QueryRunner runner = new QueryRunner();
            classifications = runner.query(connection, sql, new BeanListHandler<Classification>(Classification.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return classifications;
    }

    public List<Commodity> selectbyclassificationNo(int classificationNo) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select A.* from book_commodity A join book_type B on A.typeNo = B.typeNo join book_classification C on B.classificationNo = C.classificationNo where c.classificationNo = ?";
        List<Commodity> commodities = null;
        try {
            QueryRunner runner = new QueryRunner();
            commodities = runner.query(connection, sql, new BeanListHandler<Commodity>(Commodity.class),classificationNo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return commodities;
    }

    public static void main (String[] args) {
        try {
            List<Commodity> selectallclassification = new ClassificationDao().selectbyclassificationNo(1);
            System.out.println(selectallclassification);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
