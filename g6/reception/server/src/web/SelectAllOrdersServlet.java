package web;

import bean.Admin;
import bean.Order;
import com.google.gson.Gson;
import dao.AdminDao;
import dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SelectAllOrdersServlet")
public class SelectAllOrdersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            OrderDao orderdao = new OrderDao();
            List<Order> orders = orderdao.selectallorders();
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(orders));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
