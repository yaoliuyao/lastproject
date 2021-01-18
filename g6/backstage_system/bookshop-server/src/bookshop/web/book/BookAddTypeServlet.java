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

@WebServlet("/api/add/booktype")
public class BookAddTypeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        try {
            BookType bookType = new BookTypeDaoImpl().addBookType(new BookType(name));
            if (bookType != null) {
                resp.getWriter().println(ResultVO.success(bookType, "添加类型完成").toJSON());
            } else {
                resp.getWriter().println(ResultVO.err(400, "添加类型失败"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
    }
}
