package bean;

import java.util.Date;

public class Comment {
    int id;
    Date time;
    int postid;
    String username;
    String content;
    int like;

    public Comment() {
    }

    public Comment(int id, Date time, int postid, String username, String content, int like) {
        this.id = id;
        this.time = time;
        this.postid = postid;
        this.username = username;
        this.content = content;
        this.like = like;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { this.username = username; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}

