package mv.daoyonhu;

import mv.beanyonhu.YonHu;
import mv.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VipDao {

    public void chonzhi(String y,String r,String vip,String name) throws Exception {
        String sql = "update yonhu set vip= 1, viptime1= ?, viptime2= ?, viptime3= ? where name= ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, y);
            pr.setString(2, r);
            pr.setString(3, vip);
            pr.setString(4, name);
            int c = pr.executeUpdate();
        }
    }


    public YonHu czvip(String name) throws Exception {
        String sql = "select * from yonhu where name =?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, name);
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






}
