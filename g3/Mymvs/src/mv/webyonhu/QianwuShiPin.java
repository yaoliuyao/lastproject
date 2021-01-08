package mv.webyonhu;

import mv.beanguanli.ShiPin;
import mv.daoyonhu.YonhuZhuyeiDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/qwsp")
public class QianwuShiPin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("vauthor");
        try {
            List<ShiPin> shiPins = new YonhuZhuyeiDao().qianwusp(name);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(shiPins).toJSON());

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
