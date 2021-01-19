package mv.webyonhu;

import mv.beanguanli.GuanLy;
import mv.beanyonhu.YonHu;
import mv.daoguanli.GuanDao;
import mv.daoyonhu.YonhuDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/yhdl")
public class YonhuDl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        int sb = 0;
        int cg = 1;
        try {
            YonHu yonHu = new YonhuDao().dl(name,pwd);
            if(yonHu == null){
                HttpSession session = req.getSession();
<<<<<<< HEAD
                session.setAttribute("sess2",null);
=======
                session.setAttribute("sess",null);
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa

                PrintWriter writer = resp.getWriter();
                writer.print(ResultVO.ok(sb).toJSON());
            }else if (yonHu != null){
                HttpSession session = req.getSession();
<<<<<<< HEAD
                session.setAttribute("sess2",yonHu);
=======
                session.setAttribute("sess",yonHu);
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa

                PrintWriter writer = resp.getWriter();
                writer.print(ResultVO.ok(cg).toJSON());
            }

        }catch (Exception ex){

        }


    }

}
