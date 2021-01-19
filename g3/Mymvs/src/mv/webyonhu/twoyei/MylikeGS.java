package mv.webyonhu.twoyei;

import mv.daoyonhu.ZhiyuanDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tjyhlkgs")
@MultipartConfig
public class MylikeGS extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("yhid");
        int id2 = Integer.parseInt(id);
        String gsid = req.getParameter("gsid");
        int gsid2 = Integer.parseInt(gsid);
        String gsname = req.getParameter("gsname");
        String gstp = req.getParameter("gstp");

        String gslike = req.getParameter("gslike");
        int gslike2 = Integer.parseInt(gslike);
        String gsjs = req.getParameter("gsjs");

        try {
            ZhiyuanDao zhiyuanDao = new ZhiyuanDao();
            zhiyuanDao.addmylikegs(id2,gsid2,gsname,gstp,gslike2,gsjs);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }

}
