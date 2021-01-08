package api;


import dao.PostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post/del")
public class PostDelApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int aid = Integer.parseInt(req.getParameter("id"));

        try {
            new PostDao().delPost(aid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除出错了！！！！");
        }
    }
}
