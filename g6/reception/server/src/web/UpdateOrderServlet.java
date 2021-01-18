package web;

import bean.Order;
import dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int status = Integer.parseInt(request.getParameter("status"));
        try {
            new OrderDao().updateorder(new Order(status));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
