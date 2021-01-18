package bookshop.dao;

import bookshop.entity.Book;

import java.util.List;


/**
 * interface 接口关键字
 * 接口：本质上就是定义一种规则、规范
 * 接口一般用public
 * 接口是比抽象类更加纯粹，“纯规则”,对类的功能进行规定！！
 * 接口不使用是没有效果，接口一般用来去约束类
 */
public interface BookDao {
    List<Book> getBooks() throws Exception;

    List<Book> getBookRecom(String typeNo) throws Exception;

    List<Book> getBooks(String query, int pagenum, int pagesize) throws Exception;

    Book getBookinfo(String id) throws Exception;

    int getBookTotal() throws Exception;

    int updateBookState(String id, int state) throws Exception;

    Book addBookInfo(Book book) throws Exception;

    Book updateBookInfo(Book book, String id) throws Exception;
}
