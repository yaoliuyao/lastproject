package web;

import bean.Cart;
import dao.CartDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productNo = Integer.parseInt(request.getParameter("productNo"));
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        int booknum = Integer.parseInt(request.getParameter("booknum"));
        double cprice = Double.parseDouble(request.getParameter("cprice"));
        try {
            new CartDao().addcart(new Cart(productNo,userNo,booknum,cprice));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
