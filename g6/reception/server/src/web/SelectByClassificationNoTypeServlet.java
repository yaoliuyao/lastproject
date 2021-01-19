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
import java.util.List;

@WebServlet("/SelectByClassificationNoTypeServlet")
public class SelectByClassificationNoTypeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int classificationNo = Integer.parseInt(request.getParameter("classificationNo"));
        BookTypeDao bookTypeDao = new BookTypeDao();
        List<BookType> bookTypes = null;
        try {
            bookTypes = bookTypeDao.selectbyclassificationNotype(classificationNo);
            String gson = new Gson().toJson(bookTypes);
            response.getWriter().write(gson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
