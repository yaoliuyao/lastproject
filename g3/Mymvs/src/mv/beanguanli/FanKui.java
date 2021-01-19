package mv.beanguanli;

import java.util.Date;

public class FanKui {

<<<<<<< HEAD
    private int fkid;
=======
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa
    private int id;
    private String name;
    private String tp;
    private String fk;
    private Date time;
    private int sf;

    public FanKui() {
    }

<<<<<<< HEAD
    public FanKui(int fkid, int id, String name, String tp, String fk, Date time, int sf) {
        this.fkid = fkid;
=======
    public FanKui(int id, String name, String tp, String fk, Date time, int sf) {
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa
        this.id = id;
        this.name = name;
        this.tp = tp;
        this.fk = fk;
        this.time = time;
        this.sf = sf;
    }

<<<<<<< HEAD
    public int getFkid() {
        return fkid;
    }

    public void setFkid(int fkid) {
        this.fkid = fkid;
    }

=======
>>>>>>> 2ec084e9a0b293423f95b1df3e408fab5b918afa
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getSf() {
        return sf;
    }

    public void setSf(int sf) {
        this.sf = sf;
    }
}
