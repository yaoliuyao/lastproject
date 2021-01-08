package DAO;

import bean.Collent;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import utils.DBhelper;

import java.sql.Connection;

public class CollentDAO {
    public Collent AddCollent(Collent collent) throws Exception{
        Connection conn = DBhelper.getConnection();
        String sql = "insert into Collent values(?,?)";
        try {
            QueryRunner runner = new QueryRunner();
            Object[] objects = {
                    collent.getAid(),
                    collent.getUserid()
            };
            runner.update(conn, sql, objects);
        }finally {
            DbUtils.closeQuietly(conn);
        }
        return collent;
    }
}
