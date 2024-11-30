package com.ahu21.pojo;

public class User {

    private Integer id;
    private String UACCOUNT;
    private String UPASSWORD;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMACCOUNT() {
        return UACCOUNT;
    }

    public void setMACCOUNT(String username) {
        this.UACCOUNT = username;
    }

    public String getMPASSWORD() {
        return UPASSWORD;
    }

    public void setMPASSWORD(String password) {
        this.UPASSWORD = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + UACCOUNT + '\'' +
                ", password='" + UPASSWORD + '\'' +
                '}';
    }
}
