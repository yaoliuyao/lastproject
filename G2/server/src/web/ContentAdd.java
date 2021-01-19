package web;

import bean.Content;
import dao.ContentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContentAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String contents = req.getParameter("content");
         String source = req.getParameter("source");
        Content content = new Content();
         content.setContents(contents);
         content.setSource(source);
        try {
            new ContentDAO().addComment(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
