package web;

import bean.BookType;
import com.sun.deploy.security.ValidationState;
import dao.BookTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteBookTypeServlet")
public class DeleteBookTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int typeNo = Integer.parseInt(request.getParameter("typeNo"));
        try {
            new BookTypeDao().deletebooktype(new BookType(typeNo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
