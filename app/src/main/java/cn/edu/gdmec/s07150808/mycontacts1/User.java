package cn.edu.gdmec.s07150808.mycontacts1;

/**
 * Created by chen on 2016/10/23.
 */
public class User {
    public static final String NAME ="name" ,PHONE="phone",QQ="qq",ADDRESS="address",WORKPLACE="workplace";
    private  String name,phone,qq,address,workplace;
    private int id_DB=-1;
    public int getId_DB() {
        return id_DB;
    }
    public void setId_DB(int id_DB) {
        this.id_DB = id_DB;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }



}
