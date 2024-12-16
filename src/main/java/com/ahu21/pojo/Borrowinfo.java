package com.ahu21.pojo;

    public class Borrowinfo {
        private String JNO;
        private String JNAME;
        private String JTYPE;
        private String JCATEGORYNAME;
        private String JJUAN;
        private String JQI;
        private String JPLACE;
        private String Bdate;
        private String Accept;

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
        public String getJTYPE() {
            return JTYPE;
        }
        public void setJTYPE(String JTYPE) {
            this.JTYPE = JTYPE;
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
        public String getBdate() {
            return Bdate;
        }
        public void setBdate(String bdate) {
            Bdate = bdate;
        }
        public String getAccept() {
            return Accept;
        }
        public void setAccept(String accept) {
            Accept = accept;
        }
        @Override
        public String toString() {
            return "Borrow{" +
                    ", JNO='" + JNO + '\'' +
                    ", JNAME='" + JNAME + '\'' +
                    ", JTYPE='" + JTYPE + '\'' +
                    ", JCATEGORYNAME='" + JCATEGORYNAME + '\'' +
                    ", JJUAN='" + JJUAN + '\'' +
                    ", JQI='" + JQI + '\'' +
                    ", JPLACE='" + JPLACE + '\'' +
                    ", BDate='" + Bdate + '\'' +
                    ", Accept='" + Accept + '\'' +
                    '}';
        }
}
