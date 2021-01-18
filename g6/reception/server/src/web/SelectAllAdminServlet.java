package web;




import bean.Admin;
import com.google.gson.Gson;
import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SelectAllAdminServlet")
public class SelectAllAdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AdminDao admindao = new AdminDao();
            List<Admin> admins = admindao.selectalladmin();
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(admins));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
