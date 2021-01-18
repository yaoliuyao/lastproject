package bean;

import java.util.Date;

public class Member {
    private int profileNo;      //会员ID
    private int userNo;         //用户编号
    private String phone;       //手机号
    private String name;        //姓名
    private String sex;         //性别
    private Date birthday;      //生日
    private int grade;          //等级 默认 lv1 级
    private int state;          //使用状态
    private Date createtime;    //注册时间

    public int getProfileNo() {
        return profileNo;
    }

    public void setProfileNo(int profileNo) {
        this.profileNo = profileNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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

    public Member() {}

    public Member(int userNo, String phone, String name, String sex, Date birthday) {
        this.userNo = userNo;
        this.phone = phone;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Member{" +
                "profileNo=" + profileNo +
                ", userNo=" + userNo +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", grade=" + grade +
                ", state=" + state +
                ", createtime=" + createtime +
                '}';
    }
}
