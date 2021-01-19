package mv.webyonhu.twoyei;

import mv.daoyonhu.ZhiyuanDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dzsppl")
public class DianzanSPPL extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String vcid = req.getParameter("vcid");
        int vcid2 = Integer.parseInt(vcid);
        try {
            new ZhiyuanDao().dzsppl(vcid2);
//            ZhiyuanDao zhiyuanDao = new ZhiyuanDao();
//            int shu = zhiyuanDao.dzsppl(vcid2);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }


    }

}
