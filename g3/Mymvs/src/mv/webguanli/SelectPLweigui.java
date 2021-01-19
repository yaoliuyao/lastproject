package mv.webguanli;

import mv.beanguanli.GeShou;
import mv.beanyonhu.Pinlunyy;
import mv.daoguanli.LookDao;
import mv.daoguanli.PinlunDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/szwgpl")
public class SelectPLweigui extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        try {
            PinlunDao pinlunDao = new PinlunDao();
            List<Pinlunyy> pinlunyys =  pinlunDao.likewgyypl(name);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(pinlunyys).toJSON());

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }

}
