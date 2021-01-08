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

@WebServlet("/gldl")
public class GuanDl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        int sb = 0;
        int cg = 1;
        try {
            GuanLy guanLy = new GuanDao().dl(name,pwd);
            if(guanLy == null){
                HttpSession session = req.getSession();
                session.setAttribute("sess",null);

                PrintWriter writer = resp.getWriter();
                writer.print(ResultVO.ok(sb).toJSON());
            }else if (guanLy != null){
                HttpSession session = req.getSession();
                session.setAttribute("sess",guanLy);

                PrintWriter writer = resp.getWriter();
                writer.print(ResultVO.ok(cg).toJSON());
            }

        }catch (Exception ex){

        }


    }
}
