package bean;

import java.util.Date;

public class Region {
    private int rid;	    //编号
    private String region;	//地区
    private Date created;   //注册时间

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Region() {}

    public Region(int rid) { this.rid = rid; }

    public Region(int rid, String region) {
        this.rid = rid;
        this.region = region;
    }
    public Region(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Region{" +
                "rid=" + rid +
                ", region='" + region + '\'' +
                ", createtime=" + created +
                '}';
    }
}
