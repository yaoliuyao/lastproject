package bean;

import java.util.Date;

public class Comments {
    int Aid;
    String Userid;
    String Comment;
    int Cgood;
    Date Ctime;

    public Comments() {
    }

    public Comments(int aid, String userid, String comment, int cgood, Date ctime) {
        Aid = aid;
        Userid = userid;
        Comment = comment;
        Cgood = cgood;
        Ctime = ctime;
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

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public int getCgood() {
        return Cgood;
    }

    public void setCgood(int cgood) {
        Cgood = cgood;
    }

    public Date getCtime() {
        return Ctime;
    }

    public void setCtime(Date ctime) {
        Ctime = ctime;
    }
}
