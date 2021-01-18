package bean;

import java.util.Date;

public class Post {
    int id;
    String username;
    String title;
    String face;
    String contents;
    Date time;
    int like;

    public Post() {
    }

    public Post(int id, String username, String title, String face, String contents, Date time, int like) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.face = face;
        this.contents = contents;
        this.time = time;
        this.like = like;
    }

    public Post(String username, String topic, String title, String contents, java.sql.Date date, int likes) {
        this.username = username;
        this.title = title;
        this.face = topic;
        this.contents = contents;
        this.time = date;
        this.like = likes;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
