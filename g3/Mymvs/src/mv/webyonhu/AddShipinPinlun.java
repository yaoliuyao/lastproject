package mv.webyonhu;

import mv.daoyonhu.YonhuZhuyeiDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addsppl")
public class AddShipinPinlun extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pl = req.getParameter("pl");
        String yyid = req.getParameter("yyid");
        String yhname = req.getParameter("yhname");
        String yhtx = req.getParameter("yhtx");
        int yyid2 = Integer.parseInt(yyid);
        String yhid = req.getParameter("yhid");
        int yhid2 = Integer.parseInt(yhid);

        try {
            YonhuZhuyeiDao yonhuZhuyeiDao = new YonhuZhuyeiDao();
            yonhuZhuyeiDao.addsppl(yyid2,pl,yhid2,yhname,yhtx);

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }

    }

}
