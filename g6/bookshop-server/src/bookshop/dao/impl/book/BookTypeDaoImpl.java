package bookshop.dao.impl.book;

import bookshop.dao.BookTypeDao;
import bookshop.entity.BookType;
import bookshop.utils.DBHelper;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class BookTypeDaoImpl implements BookTypeDao {
    @Override
    public List<BookType> getBookTypeList() throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from book_type";

        try {
            return new QueryRunner().query(conn, sql, new BeanListHandler<>(BookType.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    //添加书籍类型
    @Override
    public BookType addBookType(BookType bookType) throws Exception {
        Connection conn = DBHelper.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into book_type(name) values(?)";

        try {
            BigDecimal id = queryRunner.insert(conn, sql, new ScalarHandler<>(), bookType.getName());
            bookType.setTypeNo(id.intValue());
            return bookType;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
