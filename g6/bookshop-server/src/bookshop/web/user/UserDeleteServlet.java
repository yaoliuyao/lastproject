package bookshop.web.user;

import bookshop.dao.impl.user.UserDaoImpl;
import bookshop.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/user/del")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            userDao.deleteUser(id);
            resp.getWriter().print(ResultVO.success(null, "删除成功").toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print(ResultVO.err(400, e.getLocalizedMessage()));
        }
    }
}
