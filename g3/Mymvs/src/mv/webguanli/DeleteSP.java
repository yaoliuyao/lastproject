package mv.webguanli;

import mv.daoguanli.DeletDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scsp")
public class DeleteSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("vid");
        try {
            new DeletDao().deletesp(id);
            resp.getWriter().print(ResultVO.ok(id).toJSON());
        } catch (Exception exception) {
            exception.printStackTrace();
            resp.getWriter().print(ResultVO.err(112, exception.getLocalizedMessage()).toJSON());
        }
    }
}
