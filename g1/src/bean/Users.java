package bean;

public class Users {
    String Userid;
    String Uphtot;
    String pwd;

    public Users() {
    }

    public Users(String userid, String uphtot, String pwd) {
        Userid = userid;
        Uphtot = uphtot;
        this.pwd = pwd;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getUphtot() {
        return Uphtot;
    }

    public void setUphtot(String uphtot) {
        Uphtot = uphtot;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
