package mv.webyonhu;

import mv.beanguanli.GeShou;
import mv.beanguanli.YinYue;
import mv.daoyonhu.YonhuZhuyeiDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/yhkangs")
public class KanGeshou extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pid = req.getParameter("pid");
        int pid2 = Integer.parseInt(pid);
        try {
            YonhuZhuyeiDao yonhuZhuyeiDao = new YonhuZhuyeiDao();
            GeShou geShou =  yonhuZhuyeiDao.dags(pid2);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(geShou).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }


    }

}
