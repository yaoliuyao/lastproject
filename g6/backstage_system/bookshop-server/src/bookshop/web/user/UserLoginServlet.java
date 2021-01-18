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

@WebServlet("/api/user/login")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        try {
            UserDaoImpl userDao = new UserDaoImpl();
            User result = userDao.userLogin(user, password);
            if (result != null) {
                resp.getWriter().print(ResultVO.success(result, "登录成功！").toJSON());
            } else {
                resp.getWriter().print(ResultVO.err(400, "用户名或密码不正确，请重试！").toJSON());
            }


        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print(ResultVO.err(400, e.getLocalizedMessage()));
        }
    }
}
