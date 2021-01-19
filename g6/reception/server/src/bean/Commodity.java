package bean;

import java.util.Date;

public class Commodity {
    private int productNo;      //图书id
    private int typeNo;         //图书分类id
    private int rid;		    //地区编号id
    private String bookName;    //图书名称
    private String author;      //作者
    private double price;       //销售价格
    private int buyCount;       //销售数量
    private int stock;          //库存
    private String cover;       //封面图
    private String content;     //图书简介
    private int state;          //使用状态
    private Date createtime;    //创建时间

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public int getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Commodity(){}

    public Commodity(int productNo) { this.productNo = productNo; }

    public Commodity(int typeNo, int rid, String bookName, String author, double price, int buyCount, int stock, String cover, String content) {
        this.typeNo = typeNo;
        this.rid = rid;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.buyCount = buyCount;
        this.stock = stock;
        this.cover = cover;
        this.content = content;
    }

    public Commodity(int typeNo, int rid, String bookName, String author, Double price, int buyCount, int stock, String cover, String content, int state, int productNo) {
        this.typeNo = typeNo;
        this.rid = rid;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.buyCount = buyCount;
        this.stock = stock;
        this.cover = cover;
        this.content = content;
        this.state = state;
        this.productNo = productNo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "productNo=" + productNo +
                ", typeNo=" + typeNo +
                ", rid=" + rid +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", buyCount=" + buyCount +
                ", stock=" + stock +
                ", cover='" + cover + '\'' +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                ", state=" + state +
                '}';
    }
}
