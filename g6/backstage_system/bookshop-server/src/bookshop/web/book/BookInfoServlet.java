package bookshop.web.book;

import bookshop.dao.impl.book.BookDaoImpl;
import bookshop.entity.Book;
import bookshop.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/book/info")
public class BookInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            Book getbookinfo = new BookDaoImpl().getBookinfo(id);
            if (getbookinfo != null) {
                resp.getWriter().println(ResultVO.success(getbookinfo, "获取成功").toJSON());
            } else {
                resp.getWriter().println(ResultVO.err(400, "获取失败").toJSON());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
    }
}
