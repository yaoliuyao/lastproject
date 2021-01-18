package bookshop.web.user;

import bookshop.dao.impl.user.UserDaoImpl;
import bookshop.entity.User;
import bookshop.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/user/info")
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            User user = new UserDaoImpl().getUser(id);
            if (user != null) {
                resp.getWriter().print(ResultVO.success(user, "查询成功").toJSON());
            } else {
                resp.getWriter().print(ResultVO.err(400, "查询失败").toJSON());
            }
        } catch (Exception e) {
            resp.getWriter().print(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
    }
}
