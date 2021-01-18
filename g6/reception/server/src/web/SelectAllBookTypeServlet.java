package web;

import bean.BookType;
import com.google.gson.Gson;
import dao.BookTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SelectAllBookTypeServlet")
public class SelectAllBookTypeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BookTypeDao bookTypeDao = new BookTypeDao();
            List<BookType> bookTypes = bookTypeDao.selectallbooktype();
            PrintWriter writer = response.getWriter();
            writer.println(new Gson().toJson(bookTypes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
