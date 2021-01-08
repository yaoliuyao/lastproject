package mv.webyonhu;

import mv.daoguanli.GuanAddDao;
import mv.daoyonhu.VipDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vipcz")
@MultipartConfig
public class VipChonzhi extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String vip = req.getParameter("vip");
        String y = req.getParameter("y");
        String r = req.getParameter("r");

        try {
            VipDao vipDao = new VipDao();
            vipDao.chonzhi(y,r,vip,name);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }

}
