package mv.webyonhu.twoyei;

import mv.daoyonhu.ZhiyuanDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dzgs")
public class DianzanGS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pid = req.getParameter("pid");
        int pid2 = Integer.parseInt(pid);
        try {
            new ZhiyuanDao().dzgs(pid2);
//            ZhiyuanDao zhiyuanDao = new ZhiyuanDao();
//            int shu = zhiyuanDao.dzgs(pid2);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }


    }

}
