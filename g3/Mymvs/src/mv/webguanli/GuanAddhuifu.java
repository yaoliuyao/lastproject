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

@WebServlet("/hf")
@MultipartConfig
public class GuanAddhuifu extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int id2 = Integer.parseInt(id);
        String hf = req.getParameter("hf");

        try {
            GuanAddDao guanAddDao = new GuanAddDao();
            guanAddDao.addhf(id2 ,hf);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }


}
