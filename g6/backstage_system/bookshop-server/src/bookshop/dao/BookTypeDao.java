package bookshop.dao;

import bookshop.entity.BookType;

import java.util.List;

public interface BookTypeDao {
    List<BookType> getBookTypeList() throws Exception;

    BookType addBookType(BookType bookType) throws Exception;
}
