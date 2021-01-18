package bookshop.web.book;

import bookshop.dao.impl.book.BookRegionDaoImpl;
import bookshop.entity.BookRegion;
import bookshop.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/add/region")
public class BookAddRegionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String region = req.getParameter("region");
        try {
            BookRegion bookRegion = new BookRegionDaoImpl().addBookRegion(new BookRegion(region));
            if (bookRegion != null) {
                resp.getWriter().println(ResultVO.success(bookRegion, "地区添加完成").toJSON());
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
    }
}
