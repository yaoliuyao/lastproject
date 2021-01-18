package api;

import dao.CommentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comment/del")
public class CommentDelApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid = Integer.parseInt(req.getParameter("id"));

        try {
            new CommentDao().delComment(cid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除出错了！！！！");
        }
    }
}
