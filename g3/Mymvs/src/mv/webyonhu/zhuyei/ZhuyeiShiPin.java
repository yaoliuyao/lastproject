package mv.webyonhu.zhuyei;

import mv.beanguanli.ShiPin;
import mv.beanguanli.YinYue;
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

@WebServlet("/zyshipin")
public class ZhuyeiShiPin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<ShiPin> shiPins = new YonhuZhuyeiDao().shiPins();

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(shiPins).toJSON());

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
