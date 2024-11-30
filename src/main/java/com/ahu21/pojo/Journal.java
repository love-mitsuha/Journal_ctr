package com.ahu21.pojo;

public class Journal {
    private String JNO;
    private String JNAME;
    private String JPOST;
    private String JYEAR;
    private String JPUBLISH;
    private String JTYPE;
    private String JCATEGORYNO;
    private String JCATEGORYNAME;
    private String JJUAN;
    private String JQI;
    private String JPLACE;
    private String JPATH;

    public String getJNO() {
        return JNO;
    }
    public void setJNO(String JNO) {
        this.JNO = JNO;
    }

    public String getJNAME() {
        return JNAME;
    }

    public void setJNAME(String JNAME) {
        this.JNAME = JNAME;
    }

    public String getJPOST() {
        return JPOST;
    }

    public void setJPOST(String JPOST) {
        this.JPOST = JPOST;
    }

    public String getJYEAR() {
        return JYEAR;
    }

    public void setJYEAR(String JYEAR) {
        this.JYEAR = JYEAR;
    }

    public String getJPUBLISH() {
        return JPUBLISH;
    }

    public void setJPUBLISH(String JPUBLISH) {
        this.JPUBLISH = JPUBLISH;
    }

    public String getJTYPE() {
        return JTYPE;
    }

    public void setJTYPE(String JTYPE) {
        this.JTYPE = JTYPE;
    }

    public String getJCATEGORYNO() {
        return JCATEGORYNO;
    }

    public void setJCATEGORYNO(String JCATEGORYNO) {
        this.JCATEGORYNO = JCATEGORYNO;
    }

    public String getJCATEGORYNAME() {
        return JCATEGORYNAME;
    }

    public void setJCATEGORYNAME(String JCATEGORYNAME) {
        this.JCATEGORYNAME = JCATEGORYNAME;
    }

    public String getJJUAN() {
        return JJUAN;
    }

    public void setJJUAN(String JJUAN) {
        this.JJUAN = JJUAN;
    }

    public String getJQI() {
        return JQI;
    }

    public void setJQI(String JQI) {
        this.JQI = JQI;
    }

    public String getJPLACE() {
        return JPLACE;
    }

    public void setJPLACE(String JPLACE) {
        this.JPLACE = JPLACE;
    }

    public String getJPATH() {
        return JPATH;
    }

    public void setJPATH(String JPATH) {
        this.JPATH = JPATH;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "JNO='" + JNO + '\'' +
                ", JNAME='" + JNAME + '\'' +
                ", JPOST='" + JPOST + '\'' +
                ", JYEAR='" + JYEAR + '\'' +
                ", JPUBLISH='" + JPUBLISH + '\'' +
                ", JTYPE='" + JTYPE + '\'' +
                ", JCATEGORYNO='" + JCATEGORYNO + '\'' +
                ", JCATEGORYNAME='" + JCATEGORYNAME + '\'' +
                ", JJUAN='" + JJUAN + '\'' +
                ", JQI='" + JQI + '\'' +
                ", JPLACE='" + JPLACE + '\'' +
                ", JPATH='" + JPATH + '\'' +
                '}';
    }
}
