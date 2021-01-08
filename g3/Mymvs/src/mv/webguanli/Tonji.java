package mv.webguanli;

import mv.beanguanli.Ton;
import mv.daoguanli.LookDao;
import mv.daoguanli.TonjiDao;
import mv.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tonji")
public class Tonji extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TonjiDao tonjiDao = new TonjiDao();
        LookDao lookDao = new LookDao();
        try {
            DecimalFormat df = new DecimalFormat("0.00");
            int zon = lookDao.getYinyueMount();//音乐总数

            int guoyu = tonjiDao.getgesouguoyu();
            int waiyu = tonjiDao.getgesouwaiyu();
            int yyu = tonjiDao.getgesouyyu();
            int liuxin = tonjiDao.getgesouliuxin();
            int minyao = tonjiDao.getgesouminyao();
            int qin = tonjiDao.getgesouqin();
            int gufen = tonjiDao.getgesougufen();
            int san = tonjiDao.getgesousan();
            int dj = tonjiDao.getgesoudj();
            int anjin = tonjiDao.getgesouanjin();

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

            Ton ton = new Ton(zon,guoyu2,waiyu2,yyu2,liuxin2,minyao2,qin2,gufen2,san2,dj2,anjin2,
                    guoyu,waiyu,yyu,liuxin,minyao,qin,gufen,san,dj,anjin);

            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.ok(ton).toJSON());

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
