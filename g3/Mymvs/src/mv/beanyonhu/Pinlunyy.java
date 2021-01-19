package mv.beanyonhu;

import java.util.Date;

public class Pinlunyy {

    private int mcid;
    private int mid;
    private String mComment;
    private Date mtime;
    private int yhid;
    private int mclike;
    private String yhname;
    private String yhtx;

    public Pinlunyy() {
    }

    public Pinlunyy(int mcid, int mid, String mComment, Date mtime, int yhid, int mclike, String yhname, String yhtx) {
        this.mcid = mcid;
        this.mid = mid;
        this.mComment = mComment;
        this.mtime = mtime;
        this.yhid = yhid;
        this.mclike = mclike;
        this.yhname = yhname;
        this.yhtx = yhtx;
    }

    public int getMcid() {
        return mcid;
    }

    public void setMcid(int mcid) {
        this.mcid = mcid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getmComment() {
        return mComment;
    }

    public void setmComment(String mComment) {
        this.mComment = mComment;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public int getYhid() {
        return yhid;
    }

    public void setYhid(int yhid) {
        this.yhid = yhid;
    }

    public int getMclike() {
        return mclike;
    }

    public void setMclike(int mclike) {
        this.mclike = mclike;
    }

    public String getYhname() {
        return yhname;
    }

    public void setYhname(String yhname) {
        this.yhname = yhname;
    }

    public String getYhtx() {
        return yhtx;
    }

    public void setYhtx(String yhtx) {
        this.yhtx = yhtx;
    }
}
