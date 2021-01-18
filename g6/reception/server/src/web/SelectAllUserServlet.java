package web;

import bean.User;
import com.google.gson.Gson;
import dao.UserDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SelectAllUserServlet")
public class SelectAllUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            UserDao userdao = new UserDao();
            List<User> users = userdao.selectalluser();
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(users));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
