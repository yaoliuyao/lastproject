package web;

import bean.Address;
import com.google.gson.Gson;
import dao.AddressDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/SelectAllAddressServlet")
public class SelectAllAddressServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AddressDao addressdao = new AddressDao();
            List<Address> addresses = addressdao.selectalladdress();
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(addresses));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
