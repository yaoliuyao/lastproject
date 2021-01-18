package api;

import bean.Comment;
import com.google.gson.Gson;
import dao.CommentDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class CommentAddApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid = Integer.parseInt(req.getParameter("cid"));
        Date date = Date.valueOf(req.getParameter("date"));
        int postid = Integer.parseInt(req.getParameter("postid"));
        String username = req.getParameter("username");
        String content = req.getParameter("content");
        int likes = Integer.parseInt(req.getParameter("likes"));

        try {
            Comment comment = new CommentDao().
                    addComments(new Comment(cid,date,postid,username,content,likes));
            String json = new Gson().toJson(comment);
            resp.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加异常");
        }
    }
}
