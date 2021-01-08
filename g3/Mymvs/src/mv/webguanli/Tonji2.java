package mv.webguanli;

import mv.beanguanli.Ton;
import mv.beanguanli.Ton2;
import mv.daoguanli.LookDao;
import mv.daoguanli.TonjiDao;
import mv.daoguanli.TonjiDao2;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

@WebServlet("/tonji2")
public class Tonji2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TonjiDao2 tonjiDao2 = new TonjiDao2();
        try {
            DecimalFormat df = new DecimalFormat("0.00");
            int zon = tonjiDao2.getMount();//点赞总数

            int guoyu = tonjiDao2.getgesouguoyu();
            int waiyu = tonjiDao2.getgesouwaiyu();
            int yyu = tonjiDao2.getgesouyyu();
            int liuxin = tonjiDao2.getgesouliuxin();
            int minyao = tonjiDao2.getgesouminyao();
            int qin = tonjiDao2.getgesouqin();
            int gufen = tonjiDao2.getgesougufen();
            int san = tonjiDao2.getgesousan();
            int dj = tonjiDao2.getgesoudj();
            int anjin = tonjiDao2.getgesouanjin();

            String guoyu2 = df.format((float)guoyu/zon);
            String waiyu2 = df.format((float)waiyu/zon);
            String yyu2 = df.format((float)yyu/zon);
            String liuxin2 = df.format((float)liuxin/zon);
            String minyao2 = df.format((float)minyao/zon);
            String qin2 = df.format((float)qin/zon);
            String gufen2 = df.format((float)gufen/zon);
            String san2 = df.format((float)san/zon);
            String dj2 = df.format((float)dj/zon);
            String anjin2 = df.format((float)anjin/zon);

            Ton2 ton2 = new Ton2(zon,guoyu2,waiyu2,yyu2,liuxin2,minyao2,qin2,gufen2,san2,dj2,anjin2,
                    guoyu,waiyu,yyu,liuxin,minyao,qin,gufen,san,dj,anjin);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(ton2).toJSON());

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }


}
