package mv.webguanli;

import mv.beanguanli.YinYue;
import mv.beanyonhu.YonHu;
import mv.daoguanli.LookDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/kanyh")
public class LookYonhu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LookDao dao = new LookDao();
        try {
            int currentPage, pageSize;

            try {
                currentPage = Integer.parseInt(req.getParameter("curr"));
            } catch (Exception e) {
                currentPage = 1;
            }

            try {
                pageSize = Integer.parseInt(req.getParameter("size"));
            } catch (Exception e) {
                pageSize = 10;
            }

            List<YonHu> yonHus = dao.yonhu(currentPage, pageSize);
            int total = dao.getyonhuMount();

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(yonHus).setPage(currentPage, pageSize, total).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.err(114, e.getLocalizedMessage()).toJSON());
        }

    }


}
