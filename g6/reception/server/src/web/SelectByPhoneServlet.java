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

/**
 * 　　* @description: TODO
 * 　　* @param ${tags}
 * 　　* @return ${return_type}
 * 　　* @throws
 * 　　* @author Administrator
 * 　　* @date $date$ $time$
 *
 */
@WebServlet("/SelectByPhoneServlet")
public class SelectByPhoneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        UserDao userdao = new UserDao();
        User user = null;
        try {
            user = userdao.selectbyphone(phone);
            String gson = new Gson().toJson(user);
            response.getWriter().write(gson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
