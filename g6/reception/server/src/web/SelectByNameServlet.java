package web;

import bean.BookType;
import bean.Commodity;
import bean.User;
import com.google.gson.Gson;
import dao.BookTypeDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectByNameServlet")
public class SelectByNameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        BookTypeDao bookTypeDao = new BookTypeDao();
        List<Commodity> commodities = null;
        try {
            commodities = bookTypeDao.selectbyname(name);
            String gson = new Gson().toJson(commodities);
            response.getWriter().write(gson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
