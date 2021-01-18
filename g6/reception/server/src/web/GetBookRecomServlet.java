package web;

import bean.Address;
import bean.Commodity;
import com.google.gson.Gson;
import dao.AddressDao;
import dao.BookTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/GetBookRecomServlet")
public class GetBookRecomServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int typeNo = Integer.parseInt(request.getParameter("typeNo"));
            BookTypeDao bookTypeDao = new BookTypeDao();
            List<Commodity> commodities = bookTypeDao.getBookRecom(typeNo);
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(commodities));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
