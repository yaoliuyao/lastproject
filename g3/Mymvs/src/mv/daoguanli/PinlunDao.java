package mv.daoguanli;

import mv.beanguanli.ShiPin;
import mv.beanguanli.YinYue;
import mv.beanyonhu.Pinlunyy;
import mv.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PinlunDao {


    public List<Pinlunyy> wgyhplyy() throws Exception {
        List<Pinlunyy> geShous = new ArrayList<Pinlunyy>();

        String sql = "select * from misicComment where mComment like '%钱%' " +
                "or mComment like '%死%' or mComment like '%侵权%' or mComment like '%傻%'"+
                "or mComment like '%滚%' or mComment like '%他妈%' or mComment like '%奸%'"+
                "or mComment like '%贱%' or mComment like '%干%' or mComment like '%草%' or mComment like '%智障%'";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql);
             ResultSet resultSet = pr.executeQuery()){
            while (resultSet.next()) {
                int mcid = resultSet.getInt(1);
                int mid = resultSet.getInt(2);
                String mComment = resultSet.getString(3);
                Date mtime = resultSet.getDate(4);
                int yhid = resultSet.getInt(5);
                int mclike = resultSet.getInt(6);
                String yhname = resultSet.getString(7);
                String yhtx = resultSet.getString(8);

                Pinlunyy gs = new Pinlunyy(mcid, mid, mComment, mtime, yhid, mclike, yhname, yhtx);
                geShous.add(gs);
            }
            return geShous;
        }
    }


    public List<Pinlunyy> likewgyypl(String ss) throws Exception {
        List<Pinlunyy> pinlunyyList = new ArrayList<Pinlunyy>();

        String sql = "select * from misicComment where mComment like ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1, "%"+ss+"%");

            try (ResultSet resultSet = pr.executeQuery()){
                while (resultSet.next()) {
                    int mcid = resultSet.getInt(1);
                    int mid = resultSet.getInt(2);
                    String mComment = resultSet.getString(3);
                    Date mtime = resultSet.getDate(4);
                    int yhid = resultSet.getInt(5);
                    int mclike = resultSet.getInt(6);
                    String yhname = resultSet.getString(7);
                    String yhtx = resultSet.getString(8);

                    Pinlunyy gs = new Pinlunyy(mcid, mid, mComment, mtime, yhid, mclike, yhname, yhtx);
                    pinlunyyList.add(gs);
                }
                return pinlunyyList;
            }

        }

    }



}
