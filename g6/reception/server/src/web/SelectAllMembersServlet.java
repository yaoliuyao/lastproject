package web;

import bean.Member;
import com.google.gson.Gson;
import dao.MemberDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SelectAllMembersServlet")
public class SelectAllMembersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MemberDao memberDao = new MemberDao();
            List<Member> members = memberDao.selectallmembers();
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(members));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
