package bean;


import java.util.Date;

public class Cart {
    private int cartNo;	    // 购物车id
    private int productNo;	//商品id(书籍编号)
    private int userNo;		//用户id
    private int booknum;	//加入购物车的商品数量
    private double cprice; 	//加入购物车时的价格
    private Date created;   //注册时间

    public int getCartNo() {
        return cartNo;
    }

    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public int getBooknum() {
        return booknum;
    }

    public void setBooknum(int booknum) {
        this.booknum = booknum;
    }

    public double getCprice() {
        return cprice;
    }

    public void setCprice(double cprice) {
        this.cprice = cprice;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreatetime(Date created) {
        this.created = created;
    }

    public Cart() {}

    public Cart(int userNo) { this.userNo = userNo; }

    public Cart(int productNo, int userNo, int booknum, double cprice) {
        this.productNo = productNo;
        this.userNo = userNo;
        this.booknum = booknum;
        this.cprice = cprice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartNo=" + cartNo +
                ", productNo=" + productNo +
                ", userNo=" + userNo +
                ", booknum=" + booknum +
                ", cprice=" + cprice +
                ", createtime=" + created +
                '}';
    }
}
