package api;

import bean.User;
import com.google.gson.Gson;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/zhuce")
public class UserZhuCeApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            User user = new UserDAO().addUser(new User(username,password));
            String json = new Gson().toJson(user);
            resp.getWriter().write(json);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("注册失败");
        }
    }
}
