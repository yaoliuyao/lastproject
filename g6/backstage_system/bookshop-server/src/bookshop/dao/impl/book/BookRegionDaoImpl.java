package bookshop.dao.impl.book;

import bookshop.dao.BookRegionDao;
import bookshop.entity.BookRegion;
import bookshop.utils.DBHelper;
import bookshop.vo.ResultVO;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class BookRegionDaoImpl implements BookRegionDao {
    @Override
    public List<BookRegion> getRegionList() throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from book_region";

        try {
            return new QueryRunner().query(conn, sql, new BeanListHandler<>(BookRegion.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
    //添加书籍地区
    @Override
    public BookRegion addBookRegion(BookRegion region) throws Exception {
        Connection conn = DBHelper.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into book_region(region) values(?) ";
        try {
            BigDecimal insert = queryRunner.insert(conn, sql, new ScalarHandler<>(), region.getRegion());
            region.setRid(insert.intValue());
            return region;

        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(ResultVO.success(new BookRegionDaoImpl().getRegionList(), "").toJSON());
    }

}
