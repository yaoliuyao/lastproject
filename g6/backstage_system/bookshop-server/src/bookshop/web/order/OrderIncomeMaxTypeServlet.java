package bookshop.web.order;

import bookshop.dao.impl.order.OrderDaoImpl;
import bookshop.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/api/order/income")
public class OrderIncomeMaxTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String day = req.getParameter("day");
        String m = req.getParameter("m");
        try {
            Map<String, Object> incomeMaxType = new OrderDaoImpl().getIncomeMaxType(day, m);
            if (incomeMaxType != null) {
                resp.getWriter().println(ResultVO.success(incomeMaxType, "获取成功").toJSON());
            } else {
                resp.getWriter().println(ResultVO.err(400, "没有数据").toJSON());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }

    }
}
