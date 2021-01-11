package bookshop.entity;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Date;

public class BookRegion {
    private int rid;
    private String region;
    private Date created;

    public BookRegion() {
    }

    public BookRegion(String region) {
        this.region = region;
    }

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
}
