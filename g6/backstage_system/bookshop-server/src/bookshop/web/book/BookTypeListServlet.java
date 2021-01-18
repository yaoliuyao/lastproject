package bookshop.web.book;

import bookshop.dao.impl.book.BookTypeDaoImpl;
import bookshop.entity.BookType;
import bookshop.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/book/type")
public class BookTypeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookTypeDaoImpl bookTypeDao = new BookTypeDaoImpl();
        try {
            List<BookType> bookTypeList = bookTypeDao.getBookTypeList();
            if (bookTypeList != null) {
                resp.getWriter().print(ResultVO.success(bookTypeList, "类型列表加载成功").toJSON());
            }
        } catch (Exception e) {
            resp.getWriter().print(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }

    }
}
