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
import java.util.List;

@WebServlet("/api/order/list")
public class OrderListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        String query = req.getParameter("query");
        int pagenum = Integer.parseInt(req.getParameter("pagenum"));
        int pagesize = Integer.parseInt(req.getParameter("pagesize"));

        OrderDaoImpl orderDao = new OrderDaoImpl();
        try {
            List<Order> orderList = orderDao.getOrderList(status, query, pagenum, pagesize);
            int orderTotal = orderDao.getOrderTotal();
            resp.getWriter().println(ResultVO.success(orderList, "订单列表加载完成").setPage(pagenum, pagesize, orderTotal).toJSON());

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print(ResultVO.err(400, e.getLocalizedMessage()).toJSON());
        }


    }
}
