package mv.webyonhu;

import mv.daoyonhu.ZhiyuanDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/kangsyyshu")
public class KanGeshouyyshu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        try {
            ZhiyuanDao zhiyuanDao = new ZhiyuanDao();
            int shu = zhiyuanDao.getgsyy(name);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(shu).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }


    }

}
