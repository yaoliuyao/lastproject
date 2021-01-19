package mv.beanyonhu;

public class LikeGeShou {

    private int xhid;
    private int pid;
    private String pname;
    private String ptp;
    private int plike;
    private String pjiesao;

    public LikeGeShou() {
    }

    public LikeGeShou(int xhid, int pid, String pname, String ptp, int plike, String pjiesao) {
        this.xhid = xhid;
        this.pid = pid;
        this.pname = pname;
        this.ptp = ptp;
        this.plike = plike;
        this.pjiesao = pjiesao;
    }

    public int getXhid() {
        return xhid;
    }

    public void setXhid(int xhid) {
        this.xhid = xhid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtp() {
        return ptp;
    }

    public void setPtp(String ptp) {
        this.ptp = ptp;
    }

    public int getPlike() {
        return plike;
    }

    public void setPlike(int plike) {
        this.plike = plike;
    }

    public String getPjiesao() {
        return pjiesao;
    }

    public void setPjiesao(String pjiesao) {
        this.pjiesao = pjiesao;
    }
}
