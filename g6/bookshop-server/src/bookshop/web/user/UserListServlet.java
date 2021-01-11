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
import java.util.List;

@WebServlet("/api/user/list")
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("userInput");

        int pagenum = Integer.parseInt(req.getParameter("pagenum"));
        int pagesize = Integer.parseInt(req.getParameter("pagesize"));
        //如果小于 0 默认值
        if (pagenum <= 0) {
            pagenum = 1;
        }
        if (pagesize <= 0) {
            pagesize = 5;
        }

        UserDaoImpl userDao = new UserDaoImpl();

        try {
            int userTotal = userDao.getUserCount();
            List<User> users = userDao.getUsers(user, pagenum, pagesize);
            if (users != null) {
                resp.getWriter().print(ResultVO.success(users, "列表加载完成").setPage(pagenum, pagesize, userTotal).toJSON());
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print(ResultVO.err(400, e.getLocalizedMessage()));
        }
    }
}
