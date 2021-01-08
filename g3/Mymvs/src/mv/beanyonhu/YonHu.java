package mv.beanyonhu;

import java.util.Date;

public class YonHu {

    private int id;
    private String name;
    private String pwd;
    private String tp;
    private int vip;
    private int viptime1;
    private int viptime2;
    private int viptime3;
    private Date time;

    public YonHu() {
    }

    public YonHu(String name, String pwd, String tp) {
        this.name = name;
        this.pwd = pwd;
        this.tp = tp;
    }

    public YonHu(int id, String name, String pwd, String tp, int vip, int viptime1, int viptime2, int viptime3, Date time) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.tp = tp;
        this.vip = vip;
        this.viptime1 = viptime1;
        this.viptime2 = viptime2;
        this.viptime3 = viptime3;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public int getViptime1() {
        return viptime1;
    }

    public void setViptime1(int viptime1) {
        this.viptime1 = viptime1;
    }

    public int getViptime2() {
        return viptime2;
    }

    public void setViptime2(int viptime2) {
        this.viptime2 = viptime2;
    }

    public int getViptime3() {
        return viptime3;
    }

    public void setViptime3(int viptime3) {
        this.viptime3 = viptime3;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
