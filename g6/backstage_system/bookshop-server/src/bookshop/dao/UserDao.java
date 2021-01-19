package bookshop.dao;

import bookshop.entity.User;

import java.util.List;

/**
 * interface 接口关键字
 * 接口：本质上就是定义一种规则、规范
 * 接口一般用public
 * 接口是比抽象类更加纯粹，“纯规则”,对类的功能进行规定！！
 * 接口不使用是没有效果，接口一般用来去约束类
 */

public interface UserDao {
    //接口中的成员：常量+方法
    //方法：默认public abstract（隐式公共与抽象）
    User addUser(User user) throws Exception;

    User userLogin(String user, String password) throws Exception;

    User updateUser(String id, User user) throws Exception;
    void deleteUser(String id) throws Exception;
    User getUser(String id) throws Exception;

    int getUserCount() throws Exception;

    List<User> getUsers(String query, int pagenum, int pagesize) throws Exception;

}
