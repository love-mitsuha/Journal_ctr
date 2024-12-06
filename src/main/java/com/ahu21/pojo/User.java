package com.ahu21.pojo;
public class User {
    private String UACCOUNT; // 用户账号
    private String UPASSWORD; // 用户密码
    private String UNAME; // 用户姓名
    private String UPHONE; // 用户电话
    private String UGENDER; // 用户性别
    private String UCAMPUS; // 用户所在校区

    // 构造器
    public User() {
    }

    // 带参数的构造器
    public User(String UACCOUNT, String UPASSWORD, String UNAME, String UPHONE, String UGENDER, String UCAMPUS) {
        this.UACCOUNT = UACCOUNT;
        this.UPASSWORD = UPASSWORD;
        this.UNAME = UNAME;
        this.UPHONE = UPHONE;
        this.UGENDER = UGENDER;
        this.UCAMPUS = UCAMPUS;
    }

    // getter 和 setter 方法
    public String getUACCOUNT() {
        return UACCOUNT;
    }

    public void setUACCOUNT(String UACCOUNT) {
        this.UACCOUNT = UACCOUNT;
    }

    public String getUPASSWORD() {
        return UPASSWORD;
    }

    public void setUPASSWORD(String UPASSWORD) {
        this.UPASSWORD = UPASSWORD;
    }

    public String getUNAME() {
        return UNAME;
    }

    public void setUNAME(String UNAME) {
        this.UNAME = UNAME;
    }

    public String getUPHONE() {
        return UPHONE;
    }

    public void setUPHONE(String UPHONE) {
        this.UPHONE = UPHONE;
    }

    public String getUGENDER() {
        return UGENDER;
    }

    public void setUGENDER(String UGENDER) {
        this.UGENDER = UGENDER;
    }

    public String getUCAMPUS() {
        return UCAMPUS;
    }

    public void setUCAMPUS(String UCAMPUS) {
        this.UCAMPUS = UCAMPUS;
    }

    // toString 方法
    @Override
    public String toString() {
        return "User{" +
                "UACCOUNT='" + UACCOUNT + '\'' +
                ", UPASSWORD='" + UPASSWORD + '\'' +
                ", UNAME='" + UNAME + '\'' +
                ", UPHONE='" + UPHONE + '\'' +
                ", UGENDER='" + UGENDER + '\'' +
                ", UCAMPUS='" + UCAMPUS + '\'' +
                '}';
    }
}
