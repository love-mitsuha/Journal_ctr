package com.ahu21.pojo;

public class Manager {
    private Integer id;
    private String MACCOUNT;
    private String MPASSWORD;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMACCOUNT() {
        return MACCOUNT;
    }

    public void setMACCOUNT(String username) {
        this.MACCOUNT = username;
    }

    public String getMPASSWORD() {
        return MPASSWORD;
    }

    public void setMPASSWORD(String password) {
        this.MPASSWORD = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + MACCOUNT + '\'' +
                ", password='" + MPASSWORD + '\'' +
                '}';
    }
}