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

@WebServlet("/api/order/daily")
public class OrderDailyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String day = req.getParameter("day");

        try {
            Map<String, Object> orderSum = new OrderDaoImpl().getOrderDaily(day);
            if (orderSum != null) {
                resp.getWriter().println(ResultVO.success(orderSum, "获取成功").toJSON());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
    }
}
