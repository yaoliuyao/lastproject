package mv.webyonhu;

import mv.daoguanli.GuanDao;
import mv.daoyonhu.YonhuDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/yhdltx")
public class YonhuDltx extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        try {
            String tx = new YonhuDao().yhdltx(name);
            if(tx == null){
                PrintWriter writer = resp.getWriter();
                writer.print(ResultVO.ok(null).toJSON());
            }else if (tx != null){
                PrintWriter writer = resp.getWriter();
                writer.print(ResultVO.ok(tx).toJSON());
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

}
