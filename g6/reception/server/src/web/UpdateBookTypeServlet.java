package web;

import bean.BookType;
import dao.BookTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/UpdateBookTypeServlet")
public class UpdateBookTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int typeNo = Integer.parseInt(request.getParameter("typeNo"));
        int classificationNo = Integer.parseInt(request.getParameter("classificationNo"));
        try {
            new BookTypeDao().updatebooktype(new BookType(typeNo,classificationNo,name));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
