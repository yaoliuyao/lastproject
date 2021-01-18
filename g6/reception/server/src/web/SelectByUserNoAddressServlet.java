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

@WebServlet("/SelectByUserNoAddressServlet")
public class SelectByUserNoAddressServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        try{
            AddressDao addressDao = new AddressDao();
            List<Address> address = addressDao.selectbyuserNoaddress(userNo);
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(address));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
