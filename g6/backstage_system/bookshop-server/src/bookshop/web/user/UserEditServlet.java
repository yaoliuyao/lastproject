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

@WebServlet("/api/user/edit")
public class UserEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("userNo");
        String name = req.getParameter("userName");
        String password = req.getParameter("userPass");
        String phone = req.getParameter("phone");
        try {
            UserDaoImpl userDao = new UserDaoImpl();
            User user = userDao.updateUser(id, new User(name, password, phone));
            if (user != null) {
                resp.getWriter().print(ResultVO.success(user, "修改完成").toJSON());
            } else {
                resp.getWriter().print(ResultVO.err(400, "修改失败").toJSON());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }

    }
}
