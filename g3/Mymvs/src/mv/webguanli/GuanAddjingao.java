package mv.webguanli;

import mv.daoguanli.GuanAddDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fasonjiangao")
@MultipartConfig
public class GuanAddjingao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int id2 = Integer.parseInt(id);
        String pl = req.getParameter("pl");
        String time = req.getParameter("time");

        try {
            GuanAddDao guanAddDao = new GuanAddDao();
            guanAddDao.addjg(id2 ,pl ,time);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }

}
