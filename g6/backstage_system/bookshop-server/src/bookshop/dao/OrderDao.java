package bookshop.dao;

import bookshop.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * interface 接口关键字
 * 接口：本质上就是定义一种规则、规范
 * 接口一般用public
 * 接口是比抽象类更加纯粹，“纯规则”,对类的功能进行规定！！
 * 接口不使用是没有效果，接口一般用来去约束类
 */
public interface OrderDao {

    List<Order> getOrderList(String status, String query, int pagenum, int pagesize) throws Exception;

    Order getOrderInfo(int orderNo) throws Exception;

    Map<String,Object> getOrderDaily(String day) throws Exception;

    Map<String,Object> getOrderMonth(String yearMonth) throws Exception;
    Map<String,Object> getIncomeMaxType(String day,String yearMonth) throws Exception;

    int getOrderTotal() throws Exception;

}
