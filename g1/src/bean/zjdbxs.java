package bean;

public class zjdbxs {
    String admins;
    String pwd;

    public zjdbxs() {
    }

    public zjdbxs(String admins, String pwd) {
        this.admins = admins;
        this.pwd = pwd;
    }

    public String getAdmins() {
        return admins;
    }

    public void setAdmins(String admins) {
        this.admins = admins;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
