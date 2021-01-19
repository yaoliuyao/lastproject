package dao;

import bean.Member;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBHelper;

import java.sql.Connection;
import java.util.List;

public class MemberDao {
    /**
     * selectallmembers 查询所有会员
     * addmember 添加会员
     * updatemember 更改会员信息
     *
     *
     */
    public List<Member> selectallmembers() throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "select * from book_member";
        List<Member> members = null;
        try {
            QueryRunner runner = new QueryRunner();
            members = runner.query(connection, sql, new BeanListHandler<Member>(Member.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
        return members;
    }

    public void addmember(Member member) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "insert into book_member(userNo,phone,name,sex,birthday,grade) values(?,?,?)";
        try {
            Object[] object = {
                    member.getUserNo(), member.getPhone(), member.getName(), member.getSex(), member.getBirthday(), member.getGrade()
            };
            QueryRunner runner = new QueryRunner();
            runner.update(connection,sql,object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
    }

    public void updatemember(Member member) throws Exception{
        Connection connection = DBHelper.getConnection();
        String sql = "update book_member set phone = ?,name = ?,sex = ?,birthday = ? where userNo = ?";
        try {
            Object[] objects = {
                member.getUserNo(),member.getPhone(),member.getName(),member.getSex(),member.getBirthday(),member.getUserNo()
            };
            QueryRunner queryRunner = new QueryRunner();
            queryRunner.update(connection,sql,objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtils.closeQuietly(connection);
        }
    }
}
