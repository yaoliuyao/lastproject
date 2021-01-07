package web;

import bean.Details;
import dao.DetailsDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailsAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int cid = Integer.parseInt(req.getParameter("cid"));
       String content = req.getParameter("content");
       String source = req.getParameter("source");
        Details de  =  new Details();
       de.setCid(cid);
       de.setContent(content);
       de.setSource(source);
        try {
            new DetailsDAO().addComment(de);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
