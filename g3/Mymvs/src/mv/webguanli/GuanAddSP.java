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

@WebServlet("/addsp")
@MultipartConfig
public class GuanAddSP extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String vip = req.getParameter("vip");
        Part cover = req.getPart("cover");

        try {

            String tpname = cover.getSubmittedFileName();
//                    + "-" + new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
            String tpdiz = getServletContext().getRealPath("/shipin/");
            new File(tpdiz).mkdir();
            cover.write(tpdiz + tpname);

            if (vip.equals("是")){
                GuanAddDao guanAddDao = new GuanAddDao();
                guanAddDao.addsp(tpname,name,1);
            }else {
                GuanAddDao guanAddDao = new GuanAddDao();
                guanAddDao.addsp(tpname,name,0);
            }


        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }
    }

    //    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String vip = req.getParameter("vip");
//        Part sp = req.getPart("cover");
//        int vs;
//        if (vip =="是"){
//            vs = 1;
//        }else {
//            vs = 0;
//        }
//
//        try {
//            String tpname = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date())
//                    + "-" + sp.getSubmittedFileName();
//            String tpdiz = getServletContext().getRealPath("/sp/");
//            new File(tpdiz).mkdir();
//            sp.write(tpdiz + tpname);
//
//
//            GuanAddDao guanAddDao = new GuanAddDao();
//            guanAddDao.addsp(tpname,name,vs);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            resp.getWriter().print("-1");
//        }
//
//    }
}
