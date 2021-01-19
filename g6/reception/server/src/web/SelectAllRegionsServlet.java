package web;

import bean.Member;
import bean.Region;
import com.google.gson.Gson;
import dao.MemberDao;
import dao.RegionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SelectAllRegionsServlet")
public class SelectAllRegionsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RegionDao regionDao = new RegionDao();
            List<Region> regions = regionDao.selectallregions();
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(regions));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
