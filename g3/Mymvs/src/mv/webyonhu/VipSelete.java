package mv.webyonhu;

import mv.beanyonhu.YonHu;
import mv.daoyonhu.VipDao;
import mv.daoyonhu.YonhuDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cazvip")
@MultipartConfig
public class VipSelete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        try {
            YonHu yonHu = new VipDao().czvip(name);
            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(yonHu).toJSON());

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

}
