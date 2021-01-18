package bookshop.dao;

import bookshop.entity.BookRegion;

import java.util.List;

public interface BookRegionDao {

    List<BookRegion> getRegionList() throws Exception;

    BookRegion addBookRegion(BookRegion region) throws Exception;
}
