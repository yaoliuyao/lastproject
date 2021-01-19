package mv.daoyonhu;

import mv.beanguanli.GuanLy;
import mv.beanyonhu.YonHu;
import mv.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class YonhuDao {

    public int zc(YonHu yonHu) throws Exception {
        String sql = "insert into yonhu(name,pwd,tp) values(?,?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, yonHu.getName());
            pr.setString(2, yonHu.getPwd());
            pr.setString(3, yonHu.getTp());

            int c = pr.executeUpdate();
            return c;
        }
    }


    public YonHu dl(String name, String pwd) throws Exception {
        String sql = "select * from yonhu where name =? and pwd =?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, name);
            pr.setString(2, pwd);
            try (ResultSet resultSet = pr.executeQuery()){
                if (resultSet.next()) {
                    YonHu yonHu = new YonHu();
                    yonHu.setId(resultSet.getInt(1));
                    yonHu.setName(resultSet.getString(2));
                    yonHu.setPwd(resultSet.getString(3));
                    yonHu.setTp(resultSet.getString(4));
                    yonHu.setVip(resultSet.getInt(5));
                    yonHu.setViptime1(resultSet.getInt(6));
                    yonHu.setViptime2(resultSet.getInt(7));
                    yonHu.setViptime3(resultSet.getInt(8));
                    yonHu.setTime(resultSet.getDate(9));
                    return yonHu;
                }
                else {
                    return null;
                }
            }
        }
    }



    public String yhdltx(String name) throws Exception {
        String sql = "select tp from yonhu where name =?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, name);
            try (ResultSet resultSet = pr.executeQuery()){
                if (resultSet.next()) {
                    String tx = resultSet.getString(1);
                    return tx;
                }
                else {
                    return null;
                }
            }
        }
    }


}
