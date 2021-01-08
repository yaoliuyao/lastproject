package mv.beanguanli;

public class ShiPin {

    private int vid;
    private String vname;
    private String vauthor;
    private int vlike;
    private int vvip;

    public ShiPin() {
    }

    public ShiPin(String vname) {
        this.vname = vname;
    }

    public ShiPin(int vid, String vname, String vauthor, int vlike, int vvip) {
        this.vid = vid;
        this.vname = vname;
        this.vauthor = vauthor;
        this.vlike = vlike;
        this.vvip = vvip;
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
