package com.ahu21.pojo;

public class Borrow {
    private String UACCOUNT;
    private String JNO;
    private String BDate;

    // Constructor
    public Borrow(String UACCOUNT, String JNO,  String BDate) {
        this.UACCOUNT = UACCOUNT;
        this.JNO = JNO;
        this.BDate = BDate;
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
        return BDate;
    }

    public void setBDate(String BDate) {
        this.BDate = BDate;
    }

    // Additional methods (e.g., toString) can be added as needed
    @Override
    public String toString() {
        return "Borrow{" +
                "UACCOUNT='" + UACCOUNT + '\'' +
                ", JNO=" + JNO + '\'' +
                ", BDate=" + BDate + '\'' +
                '}';
    }
}
