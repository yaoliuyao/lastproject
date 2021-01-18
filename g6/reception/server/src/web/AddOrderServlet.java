package web;

import bean.Order;
import dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        int productNo = Integer.parseInt(request.getParameter("productNo"));
        int addressNo = Integer.parseInt(request.getParameter("addressNo"));
        int payment_number = Integer.parseInt(request.getParameter("payment_number"));
        int productnum = Integer.parseInt(request.getParameter("productnum"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String remarks = request.getParameter("remarks");
        try {
            new OrderDao().addorder(new Order(userNo,productNo,addressNo,payment_number,productnum,amount,remarks));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
