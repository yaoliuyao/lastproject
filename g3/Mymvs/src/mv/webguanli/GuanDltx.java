package mv.webguanli;

import mv.beanguanli.GuanLy;
import mv.daoguanli.GuanDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dltx")
public class GuanDltx extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
//        String my = "没有";
        try {
            String tx = new GuanDao().dltx(name);
            if(tx == null){
                PrintWriter writer = resp.getWriter();
//                System.out.println(ResultVO.ok(my).toJSON());
                writer.print(ResultVO.ok(null).toJSON());
            }else if (tx != null){
                PrintWriter writer = resp.getWriter();
//                System.out.println(ResultVO.ok(tx).toJSON());
                writer.print(ResultVO.ok(tx).toJSON());
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

}
