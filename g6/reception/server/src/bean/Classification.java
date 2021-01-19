package bean;

import java.util.Date;

public class Classification {
    private int classificationNo;   //ID
    private String name;            //类型名称
    private Date createtime;        //注册时间

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

    public Classification() {}

    public Classification(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "classificationNo=" + classificationNo +
                ", name='" + name + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
