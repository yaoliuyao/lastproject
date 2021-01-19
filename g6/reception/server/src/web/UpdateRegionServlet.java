package web;

import bean.Region;
import dao.RegionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateRegionServlet")
public class UpdateRegionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));
        String region = request.getParameter("region");
        try {
            new RegionDao().updateregion(new Region(rid,region));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
