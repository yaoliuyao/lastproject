package web;

import bean.Details;
import dao.DetailsDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailsDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int ids = Integer.parseInt(req.getParameter("id"));
        try {
            new DetailsDAO().delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
