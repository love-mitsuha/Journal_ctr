package com.ahu21.pojo;

public class Returnaccept {
    private String UACCOUNT;
    private String JNO;
    private String Rdate;
    private String Accept;

    public Returnaccept(String UACCOUNT, String JNO, String Rdate, String Accept) {
        this.UACCOUNT=UACCOUNT;
        this.JNO=JNO;
        this.Rdate=Rdate;
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

    public String getRDate(){return  Rdate;}

    public void setRDate(String RDate) {
        this.Rdate = RDate;
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
        return "Return{" +
                "UACCOUNT='" + UACCOUNT + '\'' +
                ", JNO='" + JNO + '\'' +
                ", Rdate='" + Rdate + '\'' +
                ", Accept='" + Accept + '\'' +
                '}';
    }

}
