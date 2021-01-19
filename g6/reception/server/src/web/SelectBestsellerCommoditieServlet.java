package web;

import bean.Commodity;
import com.google.gson.Gson;
import dao.CommodityDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SelectBestsellerCommoditieServlet")
public class SelectBestsellerCommoditieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Commodity> commodities = new CommodityDao().selectbestsellercommoditie();
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(commodities));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
