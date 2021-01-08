package bean;

import java.util.Date;

public class Collent {
    int Cid;
    String Userid;
    int Aid;
    Date CollentTime;

    public Collent() {
    }

    public Collent(int cid, String userid, int aid, Date collentTime) {
        Cid = cid;
        Userid = userid;
        Aid = aid;
        CollentTime = collentTime;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public int getAid() {
        return Aid;
    }

    public void setAid(int aid) {
        Aid = aid;
    }

    public Date getCollentTime() {
        return CollentTime;
    }

    public void setCollentTime(Date collentTime) {
        CollentTime = collentTime;
    }
}
