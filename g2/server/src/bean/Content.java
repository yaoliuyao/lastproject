package bean;

import java.util.Date;

public class Content {
    private int id ;
    private String title;
    private String contents;
    private int commentary;
    private int likeit;
    private Date releasadata;
    private String source;
    private int status;

    public Content() {

    }

    public Content(String title, String contents, int commentary, int likeit, Date releasadata, String source, int status) {
        this.title = title;
        this.contents = contents;
        this.commentary = commentary;
        this.likeit = likeit;
        this.releasadata = releasadata;
        this.source = source;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getCommentary() {
        return commentary;
    }

    public void setCommentary(int commentary) {
        this.commentary = commentary;
    }

    public int getLikeit() {
        return likeit;
    }

    public void setLikeit(int likeit) {
        this.likeit = likeit;
    }

    public Date getReleasadata() {
        return releasadata;
    }

    public void setReleasadata(Date releasadata) {
        this.releasadata = releasadata;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
