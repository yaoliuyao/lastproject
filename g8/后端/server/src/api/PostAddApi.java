package api;


import bean.Post;
import com.google.gson.Gson;
import dao.PostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/post/add")
public class PostAddApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String topic = req.getParameter("topic");
        String title = req.getParameter("title");
        String contents = req.getParameter("contents");
        Date date = Date.valueOf(req.getParameter("date"));
        int likes = Integer.parseInt(req.getParameter("likes"));

        try {
            Post post = new PostDao().
                    addPosts(new Post(username,topic,title,contents,date,likes));
            String json = new Gson().toJson(post);
            resp.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加异常");
        }
    }
}
