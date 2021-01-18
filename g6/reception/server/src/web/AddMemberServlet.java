package web;

import bean.Member;
import dao.MemberDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddMemberServlet")
public class AddMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        try {
            Date birthday = simpleDateFormat.parse(request.getParameter("birthday"));
            new MemberDao().addmember(new Member(userNo,phone,name,sex,birthday));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
