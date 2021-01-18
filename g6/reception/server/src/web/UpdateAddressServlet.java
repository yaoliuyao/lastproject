package web;

import bean.Address;
import dao.AddressDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateAddressServlet")
public class UpdateAddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        String consignee = request.getParameter("consignee");
        String detail_address = request.getParameter("detail_address");
        String tel = request.getParameter("tel");
        try {
            new AddressDao().updateaddress(new Address(userNo,consignee,detail_address,tel));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
