package bookshop.entity;

import java.util.Date;

public class BookType {
    private int typeNo;
    private String name;
    private Date createTime;


    public BookType() {
    }

    public BookType(String name) {
        this.name = name;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
