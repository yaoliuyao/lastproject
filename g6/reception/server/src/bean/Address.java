package bean;


import java.util.Date;

public class Address {
    private int addressNo;		    //地址编号
    private int userNo;				//用户 id
    private String consignee;       //收货人
    private String detail_address;  //收货详细地址
    private String tel;	            //收货人手机号
    private Date created;           //注册时间


    public int getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(int addressNo) {
        this.addressNo = addressNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Address() {}

    public Address(int userNo) {
        this.userNo = userNo;
    }
    public Address(int userNo, String consignee, String detail_address, String tel) {
        this.userNo = userNo;
        this.consignee = consignee;
        this.detail_address = detail_address;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressNo=" + addressNo +
                ", userNo=" + userNo +
                ", consignee='" + consignee + '\'' +
                ", detail_address='" + detail_address + '\'' +
                ", tel='" + tel + '\'' +
                ", createtime=" + created +
                '}';
    }
}
