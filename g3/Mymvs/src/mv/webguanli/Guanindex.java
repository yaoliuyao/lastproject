package mv.webguanli;

import mv.beanguanli.GuanLy;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/pd")
public class Guanindex extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        GuanLy guanLy = (GuanLy) session.getAttribute("sess");
//        String my = "空";
//        String my2 = "有很多";
//        if (guanLy == null){
//            PrintWriter writer = resp.getWriter();
//            writer.print(ResultVO.ok(my).toJSON());
//        }else {
//            PrintWriter writer = resp.getWriter();
//            writer.print(ResultVO.ok(my2).toJSON());
//        }
        PrintWriter writer = resp.getWriter();
        writer.print(ResultVO.ok(guanLy).toJSON());

    }
}
