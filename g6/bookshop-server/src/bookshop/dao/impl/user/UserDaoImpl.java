package bookshop.dao.impl.user;

import bookshop.dao.UserDao;
import bookshop.entity.User;
import bookshop.utils.DBHelper;
import bookshop.vo.ResultVO;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/**
 * 用户管理类，实现 UserDao 接口(意味着要遵守接口定义的规则)
 * 在类中要重写接口中定义的方法
 * 接口是比抽象类更加纯粹，“纯规则”,对类的功能进行规定！！
 */
public class UserDaoImpl implements UserDao {


    @Override
    public User addUser(User user) throws Exception {

        return null;
    }

    /**
     * 用户登录方法
     *
     * @param user     用户名 或 手机号
     * @param password 登录密码
     * @return 返回登录的信息
     * @throws Exception
     */
    @Override
    public User userLogin(String user, String password) throws Exception {
        Connection conn = DBHelper.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            String sql = "select userno,username,userpass,phone,state,createtime from book_user " +
                    "where username = ? or phone = ? and userpass = ? ";
            Object[] params = {
                    user,
                    user,
                    password
            };
            User query = queryRunner.query(conn, sql, new BeanHandler<>(User.class), params);
            return query;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 修改用户信息方法
     *
     * @param id   根据此 id 做为条件
     * @param user
     * @return 返回 用户信息
     * @throws Exception
     */
    @Override
    public User updateUser(String id, User user) throws Exception {
        Connection conn = DBHelper.getConnection();
        try {
            QueryRunner queryRunner = new QueryRunner();
            String sql = "update book_user " +
                    "set username = ?, userpass = ?, phone = ? " +
                    "where userno = ? and state = 1";
            Object[] params = {
                    user.getUserName(),
                    user.getUserPass(),
                    user.getPhone(),
                    id,
            };
            queryRunner.update(conn, sql, params);
            user.setUserNo(Integer.parseInt(id));
            return user;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 根据用户编号删除某个用户方法 。修改 state 的状态，1表示正常，0表示删除
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteUser(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update book_user set state = 0 where userno = ? and state = 1 ";
        try {
            queryRunner.update(conn, sql, id);

        } finally {
            DbUtils.closeQuietly(conn);
        }

    }

    /**
     * 根据 传入 的id 查询 对应的用户数据
     *
     * @param id
     * @return 查询到的用户对象
     * @throws Exception
     */
    @Override
    public User getUser(String id) throws Exception {
        Connection conn = DBHelper.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select * from book_user where userNo= ? and state = 1 ";
        try {
            User query = qr.query(conn, sql, new BeanHandler<>(User.class), id);
            return query;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 分页展示数据
     *
     * @param query    查询参数： 根据用户名 或 手机号查询
     * @param pagenum  查询的页数
     * @param pagesize 每页显示的行数
     * @return 返回用户列表
     * @throws Exception
     */
    @Override
    public List<User> getUsers(String query, int pagenum, int pagesize) throws Exception {
        //判断页数
        if (pagenum == 1) {
            pagenum = pagenum - 1;
        } else if (pagenum <= 0) {
            pagenum = 0;
        } else {
            pagenum = (pagenum - 1) * pagesize;

        }
        Connection conn = DBHelper.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            String sql = "select userno,username,userpass,phone ,state,createtime from " +
                    "(select * from book_user where state = 1) book_user " +
                    "where username like ? or phone like ? " +
                    "order by userno  \n" +
                    "offset ? rows\n" +
                    "fetch next ? rows only ;";

            Object[] params = {
                    "%" + query + "%",
                    "%" + query + "%",
                    pagenum,
                    pagesize,
            };
            List<User> users = queryRunner.query(conn, sql, new BeanListHandler<>(User.class), params);
            return users;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 获取 total(总数量)
     * @return
     * @throws Exception
     */
    public int getUserCount() throws Exception {
        Connection conn = DBHelper.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String sql = "select count(*) as total from book_user where state = 1";
        try {
            Object total = queryRunner.query(conn, sql, new ScalarHandler<>("total"));
            return (int) total;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public static void main(String[] args) throws Exception {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.getUserCount());
        System.out.println(ResultVO.success(userDao.getUsers("", 0, 5), "成功").toJSON());
        User tom = userDao.getUser("1");
        userDao.deleteUser("1");
        System.out.println(tom);
        System.out.println(ResultVO.success(tom, "成功").toJSON());

    }
}
