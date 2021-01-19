package mv.webyonhu.Yonhugeren;

import mv.beanyonhu.YonHu;
import mv.daoyonhu.YonhuDao;
import mv.daoyonhu.YonhuGerenDao;

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

@WebServlet("/vipbjt")
@MultipartConfig
public class Vipbju extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("yhid");
        int id2 = Integer.parseInt(id);
        Part cover = req.getPart("cover");

        try {

            String tpname = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date())
                    + "-" + cover.getSubmittedFileName();
            String tpdiz = getServletContext().getRealPath("/vipbjt/");
            new File(tpdiz).mkdir();
            cover.write(tpdiz + tpname);

            int a = new YonhuGerenDao().bjt(id2,tpname);


        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }


}
