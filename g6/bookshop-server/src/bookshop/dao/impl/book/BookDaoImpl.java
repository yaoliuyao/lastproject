package bookshop.dao.impl.book;

import bookshop.dao.BookDao;
import bookshop.entity.Book;
import bookshop.utils.DBHelper;
import bookshop.vo.ResultVO;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * 书籍管理类，实现 BookDao 接口(意味着要遵守接口定义的规则)
 * 在类中要重写接口中定义的方法
 * 接口是比抽象类更加纯粹，“纯规则”,对类的功能进行规定！！
 */
public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getBooks() throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from book_commodity " +
                "left join book_type on book_type.typeNo=book_commodity.typeNo " +
                "join book_region on book_commodity.rid=book_region.rid " +
                "where book_commodity.state = 2";

        try {
            QueryRunner queryRunner = new QueryRunner();
            List<Book> query = queryRunner.query(conn, sql, new BeanListHandler<>(Book.class));
            return query;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 轮播，推荐销量最低的四本书籍
     * <p>
     * params typeNo 书籍类型编号
     *
     * @return 该编号最低销量的四本书籍
     * @throws Exception
     */
    @Override
    public List<Book> getBookRecom(String typeNo) throws Exception {
        Connection conn = DBHelper.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from book_commodity\n" +
                "left join book_type on book_commodity.typeno=book_type.typeNo\n" +
                "where book_commodity.typeNo=?\n" +
                "order by buyCount \n" +
                "offset 0 rows \n" +
                "fetch next 4 rows only";
        try {
            List<Book> query = queryRunner.query(conn, sql, new BeanListHandler<>(Book.class), typeNo);
            return query;
        } finally {
            DbUtils.closeQuietly(conn);
        }

    }

    /**
     * 分页查询，根据条件查询，返回一个书籍列表
     *
     * @param query
     * @param pagenum  页码
     * @param pagesize 每页显示几条
     * @return booklist
     * @throws Exception
     */
    @Override
    public List<Book> getBooks(String query, int pagenum, int pagesize) throws Exception {
        if (pagenum <= 0 || pagenum == 1) {
            pagenum = 0;
        } else {
            pagenum = (pagenum - 1) * pagesize;
        }
        Connection conn = DBHelper.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = " select * from book_commodity \n" +
                " left join book_type on book_type.typeNo= book_commodity.typeNo\n" +
                " join book_region on book_commodity.rid = book_region.rid\n" +
                "where book_commodity.state = 1 or book_commodity.state = 2 and bookName like ? or name like ? " +
                " order by book_commodity.productNo\n" +
                " offset ? rows\n" +
                " fetch next ? rows only  ";
        try {
            Object[] params = {
                    "%" + query + "%",
                    "%" + query + "%",
                    pagenum, pagesize
            };
            return queryRunner.query(conn, sql, new BeanListHandler<>(Book.class), params);

        } finally {
            DbUtils.closeQuietly(conn);
        }

    }

    /**
     * 根据 编号 获取某本书籍的信息
     *
     * @param id
     * @return 书籍信息
     * @throws Exception
     */
    @Override
    public Book getBookinfo(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = " select * from book_commodity \n" +
                " left join book_type on book_type.typeNo= book_commodity.typeNo\n" +
                " join book_region on book_commodity.rid = book_region.rid\n" +
                "where book_commodity.productNo = ? ";
        try {
            return (Book) new QueryRunner().query(conn, sql, new BeanHandler<>(Book.class), id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 统计有几本书籍
     *
     * @return
     * @throws Exception
     */
    @Override
    public int getBookTotal() throws Exception {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) total from book_commodity";
        try {
            return new QueryRunner().query(conn, sql, new ScalarHandler<>("total"));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 更新书籍状态
     * 是否上架书籍 ，1表示上架 2表示下架 0表示删除
     *
     * @param id 根据编号做为条件
     * @return 返回最新状态
     * @throws Exception
     */
    @Override
    public int updateBookState(String id, int state) throws Exception {
        if (state == 1) {
            state = 2;
        } else if (state == 2) {
            state = 1;
        }
        Connection conn = DBHelper.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update book_commodity set state = ? where productNo= ? ";
        queryRunner.update(conn, sql, state, id);

        return state;
    }

    /**
     * 添加书籍
     *
     * @param book
     * @return 返回当前添加的书籍
     * @throws Exception
     */
    @Override
    public Book addBookInfo(Book book) throws Exception {
        Connection conn = DBHelper.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into book_commodity(typeNo,rid,bookName,author,price,buyCount,stock,cover,content)" +
                " values(?,?,?,?,?,?,?,?,?)";
        Object[] params = {
                book.getTypeNo(),
                book.getRid(),
                book.getBookName(),
                book.getAuthor(),
                book.getPrice(),
                book.getBuyCount(),
                book.getStock(),
                book.getCover(),
                book.getContent()
        };
        try {
            BigDecimal insert = queryRunner.insert(conn, sql, new ScalarHandler<>(), params);
            book.setProductNo(insert.intValue());
            return book;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 更新书籍信息
     *
     * @param book
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Book updateBookInfo(Book book, String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update book_commodity " +
                "set typeNo = ?,rid = ?,bookName = ?,author = ?,price = ?," +
                "buyCount = ?,stock = ?,cover = ?,content =? " +
                "where productNo =?";
        Object[] params = {
                book.getTypeNo(), book.getRid(), book.getBookName(),
                book.getAuthor(), book.getPrice(), book.getBuyCount(),
                book.getStock(), book.getCover(), book.getContent(),
                id
        };
        try {
            queryRunner.update(conn, sql, params);
            book.setProductNo(Integer.parseInt(id));
            return book;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
