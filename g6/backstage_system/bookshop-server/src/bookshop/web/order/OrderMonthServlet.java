package bookshop.web.order;

import bookshop.dao.impl.order.OrderDaoImpl;
import bookshop.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@WebServlet("/api/order/month")
public class OrderMonthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String m = req.getParameter("m");

        try {
            Map<String, Object> orderMonth = new OrderDaoImpl().getOrderMonth(m);
            if (orderMonth != null) {
                resp.getWriter().println(ResultVO.success(orderMonth, "月销售额获取成功").toJSON());
            } else {
                resp.getWriter().println(ResultVO.err(400, "月销额获取失败").toJSON());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
    }
}
