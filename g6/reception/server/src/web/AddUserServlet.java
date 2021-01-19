package web;

import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String userpass = request.getParameter("userpass");
            String phone = request.getParameter("phone");
            UserDao userdao = new UserDao();
            userdao.adduser(new User(username,userpass,phone));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
