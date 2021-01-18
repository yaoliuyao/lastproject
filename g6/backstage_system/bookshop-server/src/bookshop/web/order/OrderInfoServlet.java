package bookshop.web.order;

import bookshop.dao.impl.order.OrderDaoImpl;
import bookshop.entity.Order;
import bookshop.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/order/info")
public class OrderInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderNo = Integer.parseInt(req.getParameter("orderNo"));

        OrderDaoImpl orderDao = new OrderDaoImpl();
        try {
            Order orderInfo = orderDao.getOrderInfo(orderNo);
            if (orderInfo != null) {
                resp.getWriter().println(ResultVO.success(orderInfo, "获取成功").toJSON());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }
    }
}
