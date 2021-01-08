package mv.webguanli;

import mv.beanguanli.GuanLy;
import mv.beanguanli.ShiPin;
import mv.beanguanli.YinYue;
import mv.daoguanli.GuanDao;
import mv.daoguanli.LookDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/szyy")
public class SelectYY extends HttpServlet {

        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        try {

            LookDao lookDao = new LookDao();
            List<YinYue> yinYues =  lookDao.like(name);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(yinYues).toJSON());

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }


    //    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        LookDao dao = new LookDao();
//        try {
//            int currentPage, pageSize;
//
//            try {
//                currentPage = Integer.parseInt(req.getParameter("curr"));
//            } catch (Exception e) {
//                currentPage = 1;
//            }
//
//            try {
//                pageSize = Integer.parseInt(req.getParameter("size"));
//            } catch (Exception e) {
//                pageSize = 10;
//            }
//
//            String name = req.getParameter("name");
//
//            List<YinYue> yinYues = dao.like(currentPage, pageSize, name);
//            int total = dao.getYinyueMount();
//
//            PrintWriter writer = resp.getWriter();
//            writer.print(ResultVO.ok(yinYues).setPage(currentPage, pageSize, total).toJSON());
//        } catch (Exception e) {
//            e.printStackTrace();
//            PrintWriter writer = resp.getWriter();
//            writer.print(ResultVO.err(114, e.getLocalizedMessage()).toJSON());
//        }
//
//    }


}
