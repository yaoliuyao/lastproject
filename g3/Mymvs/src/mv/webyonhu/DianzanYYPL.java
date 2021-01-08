package mv.webyonhu;

import mv.daoyonhu.ZhiyuanDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dzyypl")
public class DianzanYYPL extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mcid = req.getParameter("mcid");
        int mcid2 = Integer.parseInt(mcid);
        try {
            ZhiyuanDao zhiyuanDao = new ZhiyuanDao();
            int shu = zhiyuanDao.dzyypl(mcid2);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }


    }

}
