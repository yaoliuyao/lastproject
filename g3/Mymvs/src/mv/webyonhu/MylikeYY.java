package mv.webyonhu;

import mv.daoyonhu.YonhuGerenDao;
import mv.daoyonhu.ZhiyuanDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mylikeyy")
@MultipartConfig
public class MylikeYY extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("yhid");
        int id2 = Integer.parseInt(id);
        String yyid = req.getParameter("yyid");
        int yyid2 = Integer.parseInt(yyid);
        String yyname = req.getParameter("yyname");
        String yyzz = req.getParameter("yyzz");
        String yytp = req.getParameter("yytp");
        String yylike = req.getParameter("yylike");
        int yylike2 = Integer.parseInt(yylike);
        String yyvip = req.getParameter("yyvip");
        int yyvip2 = Integer.parseInt(yyvip);
        String yylx = req.getParameter("yylx");

        try {
            ZhiyuanDao zhiyuanDao = new ZhiyuanDao();
            zhiyuanDao.addmylikeyy(id2,yyid2,yyname,yyzz,yytp,yylike2,yyvip2,yylx);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }

}
