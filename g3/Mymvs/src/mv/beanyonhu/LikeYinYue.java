package mv.beanyonhu;

public class LikeYinYue {

    private int xhid;
    private int mid;
    private String mname;
    private String mauthor;
    private String mtp;
    private int mlike;
    private int mvip;
    private String mlx;

    public LikeYinYue() {
    }

    public LikeYinYue(int xhid, int mid, String mname, String mauthor, String mtp, int mlike, int mvip, String mlx) {
        this.xhid = xhid;
        this.mid = mid;
        this.mname = mname;
        this.mauthor = mauthor;
        this.mtp = mtp;
        this.mlike = mlike;
        this.mvip = mvip;
        this.mlx = mlx;
    }

    public int getXhid() {
        return xhid;
    }

    public void setXhid(int xhid) {
        this.xhid = xhid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMauthor() {
        return mauthor;
    }

    public void setMauthor(String mauthor) {
        this.mauthor = mauthor;
    }

    public String getMtp() {
        return mtp;
    }

    public void setMtp(String mtp) {
        this.mtp = mtp;
    }

    public int getMlike() {
        return mlike;
    }

    public void setMlike(int mlike) {
        this.mlike = mlike;
    }

    public int getMvip() {
        return mvip;
    }

    public void setMvip(int mvip) {
        this.mvip = mvip;
    }

    public String getMlx() {
        return mlx;
    }

    public void setMlx(String mlx) {
        this.mlx = mlx;
    }
}
