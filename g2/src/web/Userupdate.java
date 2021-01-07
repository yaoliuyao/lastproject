package web;

import dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Userupdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           int  id= Integer.parseInt(req.getParameter("id"));
            String password = req.getParameter("password");
        try {
            new UsersDAO().update(id,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
