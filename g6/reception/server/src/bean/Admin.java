package bean;

import java.util.Date;

public class Admin {
    private int uid;            //主键ID
    private String user;        //管理员账号
    private String password;    //管理员密码
    private Date createtime;    //注册时间
    private int state;          //使用状态

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Admin() {

    }

    public Admin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "uid=" + uid +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", createtime=" + createtime +
                ", state=" + state +
                '}';
    }
}
