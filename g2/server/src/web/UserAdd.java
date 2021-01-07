package web;

import bean.Details;
import bean.Users;
import dao.DetailsDAO;
import dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String image = req.getParameter("image");
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        Users users = new Users();
        users.setImage(image);
        users.setPassword(password);
        users.setUsername(username);
        users.setPhone(phone);
        try {
            new UsersDAO().addUser(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
