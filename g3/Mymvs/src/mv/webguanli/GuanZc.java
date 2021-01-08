package mv.webguanli;

import mv.beanguanli.GuanLy;
import mv.daoguanli.GuanDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/glzc")
@MultipartConfig
public class GuanZc extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        Part cover = req.getPart("cover");

        try {

            String tpname = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date())
                    + "-" + cover.getSubmittedFileName();
            String tpdiz = getServletContext().getRealPath("/img/");
            new File(tpdiz).mkdir();
            cover.write(tpdiz + tpname);


            GuanDao guanDao = new GuanDao();
            guanDao.zc(new GuanLy(name, pwd, tpname));

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }
}
