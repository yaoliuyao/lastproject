package mv.webyonhu;

import mv.beanyonhu.Jingao;
import mv.beanyonhu.LikeYinYue;
import mv.daoyonhu.YonhuDao;
import mv.daoyonhu.YonhuGerenDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/jgyh")
public class SelectJingao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        int id2 = Integer.parseInt(id);

        try {
            Jingao jingao = new YonhuDao().cxjg(id2);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(jingao).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("-1");
        }


    }

}
