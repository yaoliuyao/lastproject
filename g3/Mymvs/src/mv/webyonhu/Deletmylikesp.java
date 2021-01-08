package mv.webyonhu;

import mv.daoyonhu.DeleteDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/yhsclksp")
public class Deletmylikesp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vid = req.getParameter("vid");
        String id = req.getParameter("id");
        try {
            new DeleteDao().yhdeletesp(vid,id);
            resp.getWriter().print(ResultVO.ok(id).toJSON());
        } catch (Exception exception) {
            exception.printStackTrace();
            resp.getWriter().print(ResultVO.err(112, exception.getLocalizedMessage()).toJSON());
        }
    }

}
