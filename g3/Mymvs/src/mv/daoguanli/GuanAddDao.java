package mv.daoguanli;

import mv.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class GuanAddDao {

    public int addsp(String sp,String name,int vip) throws Exception {
        String sql = "insert into video(vname,vauthor,vvip) values(?,?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, sp);
            pr.setString(2, name);
            pr.setInt(3, vip);

            int c = pr.executeUpdate();
            return c;
        }
    }

    public int addyy(String yy,String name,String tp,int vip,String lx) throws Exception {
        String sql = "insert into misic(mname,mauthor,mtp,mvip,mlx) values(?,?,?,?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, yy);
            pr.setString(2, name);
            pr.setString(3, tp);
            pr.setInt(4, vip);
            pr.setString(5, lx);

            int c = pr.executeUpdate();
            return c;
        }
    }

    public int addgs(String name,String tp,String js) throws Exception {
        String sql = "insert into player(pname,ptp,pjiesao) values(?,?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, name);
            pr.setString(2, tp);
            pr.setString(3, js);

            int c = pr.executeUpdate();
            return c;
        }
    }


    public int addhf(int id,String name) throws Exception {
        String sql = "insert into huifu(id, hf) values(?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);
            pr.setString(2, name);

            int c = pr.executeUpdate();
            return c;
        }
    }


    public int addjg(int id, String pl, String time) throws Exception {
        String sql = "insert into jiangao(id, mComment, mtime) values(?,?,?)";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setInt(1, id);
            pr.setString(2, pl);
            pr.setString(3, time);

            int c = pr.executeUpdate();
            return c;
        }
    }


}
