package web;

import bean.Commodity;
import dao.CommodityDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddCommoditieServlet")
public class AddCommoditieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typeNo = Integer.parseInt(request.getParameter("typeNo"));
        int rid = Integer.parseInt(request.getParameter("rid"));
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        int buyCount = Integer.parseInt(request.getParameter("buyCount"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String cover = request.getParameter("cover");
        String content =request.getParameter("content");
        try {
            new CommodityDao().addcommoditie(new Commodity(typeNo,rid,bookName,author,price,buyCount,stock,cover,content));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
