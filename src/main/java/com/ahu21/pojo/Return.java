package com.ahu21.pojo;

public class Return {
    private String UACCOUNT;
    private String JNO;
    private String RDate;
    private String Accept;

    public Return(String UACCOUNT, String JNO, String RDate,String Accept) {
        this.UACCOUNT=UACCOUNT;
        this.JNO=JNO;
        this.RDate=RDate;
        this.Accept = Accept;
    }

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

    public String getRDate(){return  RDate;}

    public void setRDate(String RDate) {
        this.RDate = RDate;
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
                ", RDate=" + RDate + '\'' +
                ", Accept='" + Accept + '\'' +
                '}';
    }

}
