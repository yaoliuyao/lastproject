package web;

import bean.Address;
import bean.Cart;
import com.google.gson.Gson;
import dao.AddressDao;
import dao.CartDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SelectAllCartsServlet")
public class SelectAllCartsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            CartDao cartdao = new CartDao();
            List<Cart> carts = cartdao.selectallcarts();
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(carts));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
