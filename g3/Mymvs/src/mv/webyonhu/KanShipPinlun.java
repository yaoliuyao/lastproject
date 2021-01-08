package mv.webyonhu;

import mv.beanyonhu.Pinlunsp;
import mv.beanyonhu.Pinlunyy;
import mv.daoyonhu.YonhuZhuyeiDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/sppl")
public class KanShipPinlun extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        YonhuZhuyeiDao yonhuZhuyeiDao = new YonhuZhuyeiDao();
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

            String vid = req.getParameter("vid");
            int vid2 = Integer.parseInt(vid);
            List<Pinlunsp> pinlunsps = yonhuZhuyeiDao.pinlunsps(vid2, currentPage, pageSize);
            int total = yonhuZhuyeiDao.getplspMount(vid2);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(pinlunsps).setPage(currentPage, pageSize, total).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.err(114, e.getLocalizedMessage()).toJSON());
        }

    }

}
