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
import java.util.List;

@WebServlet("/post/list")
public class PostListApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json;charset=utf-8");
            List<Post> posts = new PostDao().getAllPosts();
            String json = new Gson().toJson(posts);
            resp.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("加载数据出错了");
        }
    }
}
