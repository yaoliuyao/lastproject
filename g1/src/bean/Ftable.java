package bean;

public class Ftable {
    int Fwid;
    String Fwname;

    public Ftable() {
    }

    public Ftable(int fwid, String fwname) {
        Fwid = fwid;
        Fwname = fwname;
    }

    public int getFwid() {
        return Fwid;
    }

    public void setFwid(int fwid) {
        Fwid = fwid;
    }

    public String getFwname() {
        return Fwname;
    }

    public void setFwname(String fwname) {
        Fwname = fwname;
    }
}
