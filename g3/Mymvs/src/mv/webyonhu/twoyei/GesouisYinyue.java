package mv.webyonhu.twoyei;

import mv.beanguanli.YinYue;
import mv.daoyonhu.YonhuGerenDao;
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

@WebServlet("/gsyinyue")
public class GesouisYinyue extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        try {
            List<YinYue> yinYues = new YonhuZhuyeiDao().gsisyy(name);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(yinYues).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }


    }

}
