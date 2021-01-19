package mv.beanyonhu;

import java.util.Date;

public class Pinlunsp {

    private int vcid;
    private int vid;
    private String vComment;
    private Date vtime;
    private int yhid;
    private int vclike;
    private String yhname;
    private String yhtx;

    public Pinlunsp() {
    }

    public Pinlunsp(int vcid, int vid, String vComment, Date vtime, int yhid, int vclike, String yhname, String yhtx) {
        this.vcid = vcid;
        this.vid = vid;
        this.vComment = vComment;
        this.vtime = vtime;
        this.yhid = yhid;
        this.vclike = vclike;
        this.yhname = yhname;
        this.yhtx = yhtx;
    }

    public int getVcid() {
        return vcid;
    }

    public void setVcid(int vcid) {
        this.vcid = vcid;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getvComment() {
        return vComment;
    }

    public void setvComment(String vComment) {
        this.vComment = vComment;
    }

    public Date getVtime() {
        return vtime;
    }

    public void setVtime(Date vtime) {
        this.vtime = vtime;
    }

    public int getYhid() {
        return yhid;
    }

    public void setYhid(int yhid) {
        this.yhid = yhid;
    }

    public int getVclike() {
        return vclike;
    }

    public void setVclike(int vclike) {
        this.vclike = vclike;
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
