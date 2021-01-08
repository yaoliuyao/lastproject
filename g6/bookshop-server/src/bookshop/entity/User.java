package bookshop.entity;

import java.util.Date;

public class User {
    private int userNo;
    private String userName;
    private String userPass;
    private String phone;
    private int state;
    private Date createTime;

    public User() {

    }

    public User(String userName, String userPass, String phone) {
        this.userName = userName;
        this.userPass = userPass;
        this.phone = phone;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
