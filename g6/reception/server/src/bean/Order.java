package bean;

import java.util.Date;

public class Order {
    private int orderNo;	    //订单编号
    private int userNo;		    //用户编号
    private int productNo;		//书籍商品编号
    private int addressNo;		//收货地址编号
    private int payment_number;	//支付方式 ,1 微信，2 支付宝
    private int productnum;		//书籍商品数量
    private double amount;	    //订单总价
    private int status;	        //订单状态 0取消付款，1待发货，2待收货，3已完成
    private String remarks;	    //订单备注
    private Date createtime;    //注册时间

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public int getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(int addressNo) {
        this.addressNo = addressNo;
    }

    public int getPayment_number() {
        return payment_number;
    }

    public void setPayment_number(int payment_number) {
        this.payment_number = payment_number;
    }

    public int getProductnum() {
        return productnum;
    }

    public void setProductnum(int productnum) {
        this.productnum = productnum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Order() {}

    public Order(int status) { this.status = status; }

    public Order(int userNo, int productNo, int addressNo, int payment_number, int productnum, double amount, String remarks) {
        this.userNo = userNo;
        this.productNo = productNo;
        this.addressNo = addressNo;
        this.payment_number = payment_number;
        this.productnum = productnum;
        this.amount = amount;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", userNo=" + userNo +
                ", productNo=" + productNo +
                ", addressNo=" + addressNo +
                ", payment_number=" + payment_number +
                ", productnum=" + productnum +
                ", amount=" + amount +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
