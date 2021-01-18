package bean;

import java.util.Date;

public class Articles {
    int Aid;
    String Userid;
    String Aname;
    String Acontent;
    Date Atime;
    int Agood;
    int Alook;

    public Articles() {
    }

    public Articles(int aid, String userid, String aname, String acontent, Date atime, int agood, int alook) {
        Aid = aid;
        Userid = userid;
        Aname = aname;
        Acontent = acontent;
        Atime = atime;
        Agood = agood;
        Alook = alook;
    }

    public Articles(String userid, String aname, String acontent, java.sql.Date atime, int agood, int alook) {
        Userid = userid;
        Aname = aname;
        Acontent = acontent;
        Atime = atime;
        Agood = agood;
        Alook = alook;
    }

    public int getAid() {
        return Aid;
    }

    public void setAid(int aid) {
        Aid = aid;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getAname() {
        return Aname;
    }

    public void setAname(String aname) {
        Aname = aname;
    }

    public String getAcontent() {
        return Acontent;
    }

    public void setAcontent(String acontent) {
        Acontent = acontent;
    }

    public Date getAtime() {
        return Atime;
    }

    public void setAtime(Date atime) {
        Atime = atime;
    }

    public int getAgood() {
        return Agood;
    }

    public void setAgood(int agood) {
        Agood = agood;
    }

    public int getAlook() {
        return Alook;
    }

    public void setAlook(int alook) {
        Alook = alook;
    }
}
