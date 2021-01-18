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
import java.util.List;

@WebServlet("/api/book/list")
public class BookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        String pagenum = req.getParameter("pagenum");
        String pagesize = req.getParameter("pagesize");
        if (pagenum != null && pagesize != null) {      //分页
            BookDaoImpl bookDao = new BookDaoImpl();
            try {
                List<Book> getbooks = bookDao.getBooks(query, Integer.parseInt(pagenum), Integer.parseInt(pagesize));
                int bookTotal = bookDao.getBookTotal();
                if (getbooks != null) {
                    resp.getWriter().print(ResultVO.success(getbooks, "列表加载成功").setPage(Integer.parseInt(pagenum), Integer.parseInt(pagesize), bookTotal).toJSON());
                } else {
                    resp.getWriter().print(ResultVO.err(400, "加载失败").toJSON());
                }
            } catch (Exception e) {
                e.printStackTrace();
                resp.getWriter().print(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
            }
        } else {     //
            try {

                List<Book> getbooks = new BookDaoImpl().getBooks();
                if (getbooks != null) {
                    resp.getWriter().println(ResultVO.success(getbooks, "加载完成").toJSON());
                } else {
                    resp.getWriter().println(ResultVO.err(400, "加载失败").toJSON());
                }
            } catch (Exception e) {
                e.printStackTrace();
                resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
            }
        }

    }
}
