package mv.webyonhu;

import mv.daoyonhu.ZhiyuanDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dzsp")
public class DianzanSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String vid = req.getParameter("vid");
        int vid2 = Integer.parseInt(vid);
        try {
            ZhiyuanDao zhiyuanDao = new ZhiyuanDao();
            int shu = zhiyuanDao.dzsp(vid2);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }


    }

}
