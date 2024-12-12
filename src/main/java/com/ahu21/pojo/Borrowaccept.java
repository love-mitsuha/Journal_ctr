package com.ahu21.pojo;

public class Borrowaccept {
    private String UACCOUNT;
    private String JNO;
    private String Bdate;
    private String Accept;

    // Constructor
    public Borrowaccept(String UACCOUNT, String JNO, String BDate,String Accept) {
        this.UACCOUNT = UACCOUNT;
        this.JNO = JNO;
        this.Bdate = BDate;
        this.Accept = Accept;
    }
    // Getters and Setters for userAccount
    public String getUACCOUNT() {
        return UACCOUNT;
    }

    public void setUACCOUNT(String UACCOUNT) {
        this.UACCOUNT = this.UACCOUNT;
    }

    // Getters and Setters for journalId
    public String getJNO() {
        return JNO;
    }

    public void setJNO(String JNO) {
        this.JNO = JNO;
    }

    // Getters and Setters for borrowDate
    public String getBDate() {
        return Bdate;
    }

    public void setBDate(String BDate) {
        this.Bdate = BDate;
    }
    public String getAccept() {
        return Accept;
    }

    public void setAccept(String Accept) {
        this.Accept = Accept;
    }

    // Additional methods (e.g., toString) can be added as needed
    @Override
    public String toString() {
        return "Borrow{" +
                "UACCOUNT='" + UACCOUNT + '\'' +
                ", JNO=" + JNO + '\'' +
                ", BDate=" + Bdate + '\'' +
                ", Accept=" + Accept + '\'' +
                '}';
    }
}
