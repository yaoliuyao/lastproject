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

@WebServlet("/dzyy")
public class DianzanYY extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mid = req.getParameter("mid");
        int mid2 = Integer.parseInt(mid);
        try {
            ZhiyuanDao zhiyuanDao = new ZhiyuanDao();
            int shu = zhiyuanDao.dzyy(mid2);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }


    }

}
