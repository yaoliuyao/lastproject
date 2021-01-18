package bookshop.web.book;

import bookshop.dao.impl.book.BookDaoImpl;
import bookshop.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/book/state")
public class BookUpdateStateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int state = Integer.parseInt(req.getParameter("state"));

        try {
            BookDaoImpl bookDao = new BookDaoImpl();
            int i = bookDao.updateBookState(id, state);
            resp.getWriter().print(ResultVO.success(i, "设置状态成功").toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
    }
}
