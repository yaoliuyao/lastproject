package bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

public class User {
    private int userno;         //ID
    private String username;    //用户名
    private String userpass;    //密码
    private String phone;       //手机号
    private int state;          //使用状态
    private Date createtime;    //注册时间

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public User() {}

    public User(String username, String userpass, String phone) {
        this.username = username;
        this.userpass = userpass;
        this.phone = phone;
    }

    public User(String userpass, String phone) {
        this.userpass = userpass;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userno=" + userno +
                ", username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", createtime=" + createtime +
                '}';
    }
}
