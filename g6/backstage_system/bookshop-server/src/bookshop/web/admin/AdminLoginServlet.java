package bookshop.web.admin;

import bookshop.dao.impl.admin.AdminDaoImpl;
import bookshop.entity.Admin;
import bookshop.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/login")
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        try {
            Admin admin1 = new AdminDaoImpl().adminLogin(user, password);
            if (admin1 != null) {
                resp.getWriter().println(ResultVO.success(admin1, "登陆成功").toJSON());
            } else {
                resp.getWriter().println(ResultVO.err(400, "帐号或密码错误").toJSON());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getMessage()).toJSON());
        }
    }
}
