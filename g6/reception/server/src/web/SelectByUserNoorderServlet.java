package web;

import bean.Address;
import bean.Order;
import com.google.gson.Gson;
import dao.AddressDao;
import dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/SelectByUserNoorderServlet")
public class SelectByUserNoorderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        try{
            OrderDao orderDao = new OrderDao();
            List<Order> orders = orderDao.selectbyuserNoorder(userNo);
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(orders));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
