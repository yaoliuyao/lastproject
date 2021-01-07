package bean;

public class Users {
    private int id;
    private String username;
    private String password;
    private int phone;
    private int usertype;
    private String image;

    public Users() {

    }

    public Users(String username, String password, int phone, int usertype, String image) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.usertype = usertype;
        this.image = image;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
