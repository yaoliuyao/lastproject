package bean;

public class UserInfo {
    String id;              //id生成UUID
    String username;        //用户名
    String password;        //密码
    String sex;             //性别
    String face;            //头像
    String regTime;         //注册时间
    String email;           //邮箱
    String mobile;          //电话号码

    public UserInfo() {
    }

    public UserInfo(String id, String username, String password, String sex, String face, String regTime, String email, String mobile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.face = face;
        this.regTime = regTime;
        this.email = email;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
