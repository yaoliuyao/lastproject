package api;

import DAO.ArticlesDAO;
import bean.Articles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/articles/add")
public class ArticlesAddApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("Userid");
        String aname = req.getParameter("Aname");
        String acontent = req.getParameter("Acontent");
        Date atime = Date.valueOf(req.getParameter("Atime"));
        int agood = Integer.parseInt(req.getParameter("Agood"));
        int alook = Integer.parseInt(req.getParameter("Alook"));
        try {
            Articles articles = new ArticlesDAO().AddArticles(new Articles(userid, aname, acontent, atime, agood, alook));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("周涛牛逼");
        }
    }

}
