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

@WebServlet("/addyy")
@MultipartConfig
public class GuanAddYY extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String vip = req.getParameter("vip");
        String lx = req.getParameter("lx");
        Part tp = req.getPart("tp");
        Part yy = req.getPart("yy");

        try {
            String tpname = tp.getSubmittedFileName();
//            String tpname = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date())
//                    + "-" + tp.getSubmittedFileName();
            String tpdiz = getServletContext().getRealPath("/yytp/");
            new File(tpdiz).mkdir();
            tp.write(tpdiz + tpname);


            String yyname = yy.getSubmittedFileName();
//                    + "-" + new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
            String yydiz = getServletContext().getRealPath("/yinyue/");
            new File(yydiz).mkdir();
            yy.write(yydiz + yyname);


            if (vip.equals("是")){
                GuanAddDao guanAddDao = new GuanAddDao();
                guanAddDao.addyy(yyname,name,tpname,1,lx);
            }else {
                GuanAddDao guanAddDao = new GuanAddDao();
                guanAddDao.addyy(yyname,name,tpname,0,lx);
            }


        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }

}
