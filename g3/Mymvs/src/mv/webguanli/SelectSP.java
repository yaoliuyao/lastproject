package mv.webguanli;

import mv.beanguanli.ShiPin;
import mv.beanguanli.YinYue;
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

@WebServlet("/szsp")
public class SelectSP extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        try {

            LookDao lookDao = new LookDao();
            List<ShiPin> shiPins =  lookDao.likesp(name);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(shiPins).toJSON());

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }

}
