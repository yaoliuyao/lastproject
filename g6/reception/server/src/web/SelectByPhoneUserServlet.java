package web;

import bean.User;
import com.google.gson.Gson;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectByPhoneUserServlet")
public class SelectByPhoneUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String userpass = request.getParameter("userpass");
        UserDao userdao = new UserDao();
        User user = null;
        try {
            user = userdao.selectbyphoneuser(phone,userpass);
            String gson = new Gson().toJson(user);
            response.getWriter().write(gson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
