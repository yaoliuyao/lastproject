package mv.webyonhu;

import mv.daoguanli.GuanAddDao;
import mv.daoyonhu.YonhuGerenDao;
import mv.daoyonhu.YonhuZhuyeiDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/yhtjfk")
@MultipartConfig
public class YonhuFankui extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int id2 = Integer.parseInt(id);
        String name = req.getParameter("name");
        String tp = req.getParameter("tp");
        String fk = req.getParameter("fk");

        try {
            YonhuGerenDao yonhuGerenDao = new YonhuGerenDao();
            yonhuGerenDao.yhfk(id2,name,tp,fk);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }

}
