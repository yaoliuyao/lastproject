package bookshop.web.book;

import bookshop.dao.impl.book.BookDaoImpl;
import bookshop.entity.Book;
import bookshop.vo.ResultVO;
import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverLocalFilesystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/book/recom")
public class BookRecomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeNo = req.getParameter("typeNo");
        BookDaoImpl bookDao = new BookDaoImpl();
        try {
            List<Book> bookRecom = bookDao.getBookRecom(typeNo);
            if (bookRecom != null) {
                resp.getWriter().println(ResultVO.success(bookRecom, "轮播列表加载完成").toJSON());
            } else {
                resp.getWriter().println(ResultVO.err(400, "轮播列表加载失败").toJSON());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
    }
}
