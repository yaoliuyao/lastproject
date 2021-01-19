package mv.beanyonhu;

public class LikeShiPin {

    private int xhid;
    private int vid;
    private String vname;
    private String vauthor;
    private int vlike;
    private int vvip;

    public LikeShiPin() {
    }

    public LikeShiPin(int xhid, int vid, String vname, String vauthor, int vlike, int vvip) {
        this.xhid = xhid;
        this.vid = vid;
        this.vname = vname;
        this.vauthor = vauthor;
        this.vlike = vlike;
        this.vvip = vvip;
    }

    public int getXhid() {
        return xhid;
    }

    public void setXhid(int xhid) {
        this.xhid = xhid;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVauthor() {
        return vauthor;
    }

    public void setVauthor(String vauthor) {
        this.vauthor = vauthor;
    }

    public int getVlike() {
        return vlike;
    }

    public void setVlike(int vlike) {
        this.vlike = vlike;
    }

    public int getVvip() {
        return vvip;
    }

    public void setVvip(int vvip) {
        this.vvip = vvip;
    }
}
