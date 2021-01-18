package bean;

import java.util.Date;

public class Collent {
    int id;
    String username;
    int postid;
    Date collenttime;

    public Collent() {
    }

    public Collent(int id, String username, int postid, Date collenttime) {
        this.id = id;
        this.username = username;
        this.postid = postid;
        this.collenttime = collenttime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public Date getCollenttime() {
        return collenttime;
    }

    public void setCollenttime(Date collenttime) {
        this.collenttime = collenttime;
    }
}
