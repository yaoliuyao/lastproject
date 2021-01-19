package web;

import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateUserpassServlet")
public class UpdateUserpassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userpass = request.getParameter("userpass");
            String phone = request.getParameter("phone");
            UserDao userdao = new UserDao();
            userdao.updateuserpass(new User(userpass,phone));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
