package bookshop.web;

import bookshop.dao.impl.order.OrderDaoImpl;
import bookshop.utils.DBHelper;
import bookshop.vo.ResultVO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

@WebServlet("/api/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");
        System.out.println(q);
        String sql = "select sum(amount) as total,count(*) count from book_order  " +
                "where datediff(dd,createTime,getdate())<= ? ";
        try {
            Connection conn = DBHelper.getConnection();
            Map<String, Object> query = new QueryRunner().query(conn, sql, new MapHandler(), q);
            System.out.println(query.get("total"));
            if (query.get("total") == null) {
                query.put("total", 0);
            }
            System.out.println(ResultVO.success(query, "2").toJSON());
            Object orderSum = new OrderDaoImpl().getOrderDaily(q);
            System.out.println(ResultVO.success(orderSum,"3").toJSON());
            resp.getWriter().println(ResultVO.success(query, "1").toJSON());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
