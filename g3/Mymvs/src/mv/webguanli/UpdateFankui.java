package mv.webguanli;

import mv.daoguanli.DeletDao;
import mv.daoguanli.LookDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fhlbian")
public class UpdateFankui extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fk = req.getParameter("fk");
        try {
            new LookDao().bian(fk);
            resp.getWriter().print(ResultVO.ok(fk).toJSON());
        } catch (Exception exception) {
            exception.printStackTrace();
            resp.getWriter().print(ResultVO.err(112, exception.getLocalizedMessage()).toJSON());
        }
    }

}
