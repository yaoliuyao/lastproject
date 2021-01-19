package mv.beanyonhu;

public class Jingao {

    private int jgid;
    private int id;
    private String mComment;
    private String mtime;

    public Jingao() {
    }

    public Jingao(int jgid, int id, String mComment, String mtime) {
        this.jgid = jgid;
        this.id = id;
        this.mComment = mComment;
        this.mtime = mtime;
    }

    public int getJgid() {
        return jgid;
    }

    public void setJgid(int jgid) {
        this.jgid = jgid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmComment() {
        return mComment;
    }

    public void setmComment(String mComment) {
        this.mComment = mComment;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }
}
