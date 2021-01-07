package web;

import dao.ContentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContentDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String ids = req.getParameter("id");
       int id  = Integer.parseInt(ids);
        try {
            new ContentDAO().delete(id);
        } catch (Exception e) {
           e.getLocalizedMessage();
        }
    }
}
