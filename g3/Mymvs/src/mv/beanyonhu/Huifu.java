package mv.beanyonhu;

public class Huifu {

    private int hfid;
    private int id;
    private String hf;

    public Huifu() {
    }

    public Huifu(int hfid, int id, String hf) {
        this.hfid = hfid;
        this.id = id;
        this.hf = hf;
    }

    public int getHfid() {
        return hfid;
    }

    public void setHfid(int hfid) {
        this.hfid = hfid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHf() {
        return hf;
    }

    public void setHf(String hf) {
        this.hf = hf;
    }
}
