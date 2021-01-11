package bookshop.entity;

import java.util.Date;

public class Book {
    private int productNo;
    private String bookName;
    private String author;
    private double price;
    private int buyCount;
    private int stock;
    private String cover;
    private String content;
    private int state;
    private Date createTime;


    //分类
    private int typeNo;
    private String name;
    //地区
    private int rid;
    private String region;

    public Book() {
    }

    public Book(int typeNo, int rid, String bookName, String author, double price, int buyCount, int stock, String content, String fileName) {
        this.typeNo = typeNo;
        this.rid = rid;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.buyCount = buyCount;
        this.stock = stock;
        this.content = content;
        this.cover = fileName;
    }

    public int getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "Book{" +
                "productNo=" + productNo +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", buyCount=" + buyCount +
                ", stock=" + stock +
                ", cover='" + cover + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", typeNo=" + typeNo +
                ", name='" + name + '\'' +
                ", rid=" + rid +
                ", region='" + region + '\'' +
                '}';
    }

    public static void main(String[] args) {

    }
}
