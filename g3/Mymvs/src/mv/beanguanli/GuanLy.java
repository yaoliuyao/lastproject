package mv.beanguanli;

public class GuanLy {

    private int gid;
    private String gname;
    private String gpwd;
    private String gtp;

    public GuanLy() {
    }

    public GuanLy(String gname) {
        this.gname = gname;
    }

    public GuanLy(String gname, String gpwd, String gtp) {
        this.gname = gname;
        this.gpwd = gpwd;
        this.gtp = gtp;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGpwd() {
        return gpwd;
    }

    public void setGpwd(String gpwd) {
        this.gpwd = gpwd;
    }

    public String getGtp() {
        return gtp;
    }

    public void setGtp(String gtp) {
        this.gtp = gtp;
    }
}
