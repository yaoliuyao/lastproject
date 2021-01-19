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
import java.util.List;

@WebServlet("/api/book/region")
public class BookRegionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<BookRegion> regionList = new BookRegionDaoImpl().getRegionList();
            if (regionList != null) {
                resp.getWriter().print(ResultVO.success(regionList, "地区列表加载完成").toJSON());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
    }
}
