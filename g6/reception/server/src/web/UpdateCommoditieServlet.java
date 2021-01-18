package web;

import bean.Commodity;
import dao.CommodityDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateCommoditieServlet")
public class UpdateCommoditieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productNo = Integer.parseInt(request.getParameter("productNo"));
        int typeNo = Integer.parseInt(request.getParameter("typeNo"));
        int rid  = Integer.parseInt(request.getParameter("rid"));
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        Double price = Double.valueOf(request.getParameter("price"));
        int buyCount = Integer.parseInt(request.getParameter("buyCount"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String cover = request.getParameter("cover");
        String content = request.getParameter("content");
        int state = Integer.parseInt(request.getParameter("state"));
        try {
            new CommodityDao().updatecommoditie(new Commodity(typeNo,rid,bookName,author,price,buyCount,stock,cover,content,state,productNo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
