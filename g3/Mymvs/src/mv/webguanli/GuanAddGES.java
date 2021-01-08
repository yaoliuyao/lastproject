package mv.webguanli;

import mv.daoguanli.GuanAddDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/addgs")
@MultipartConfig
public class GuanAddGES extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String jiesao = req.getParameter("js");
        Part tp = req.getPart("tp");

        try {
            String tpname = tp.getSubmittedFileName();
//            String tpname = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date())
//                    + "-" + tp.getSubmittedFileName();
            String tpdiz = getServletContext().getRealPath("/geshoutp/");
            new File(tpdiz).mkdir();
            tp.write(tpdiz + tpname);


            GuanAddDao guanAddDao = new GuanAddDao();
            guanAddDao.addgs(name,tpname,jiesao);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }

}
