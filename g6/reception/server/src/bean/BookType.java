package bean;

import java.util.Date;

public class BookType {
    private int typeNo;             //ID
    private int classificationNo;   //种类ID
    private String name;            //类型名称
    private Date createtime;        //注册时间

    public int getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public int getClassificationNo() {
        return classificationNo;
    }

    public void setClassificationNo(int classificationNo) {
        this.classificationNo = classificationNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public BookType() {}

    public BookType(String name) {
        this.name = name;
    }

    public BookType(int typeNo) { this.typeNo = typeNo; }

    public BookType(int typeNo, String name) {
        this.name = name;
        this.typeNo = typeNo;
    }

    public BookType(String name,int classificationNo) {
        this.name = name;
        this.classificationNo = classificationNo;
    }

    public BookType(int typeNo, int classificationNo, String name) {
        this.typeNo = typeNo;
        this.classificationNo = classificationNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "typeNo=" + typeNo +
                ", classificationNo=" + classificationNo +
                ", name='" + name + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
