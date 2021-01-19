package mv.webyonhu;

import mv.beanyonhu.YonHu;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/pd2")
public class Yonhuindex extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
<<<<<<< HEAD
        YonHu yonHu = (YonHu) session.getAttribute("sess2");
=======
        YonHu yonHu = (YonHu) session.getAttribute("sess");
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa

        if(yonHu!=null){
            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(yonHu).toJSON());
        }else {
            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(404).toJSON());
        }

//        PrintWriter writer = resp.getWriter();
//        writer.print(ResultVO.ok(yonHu).toJSON());

    }

}
