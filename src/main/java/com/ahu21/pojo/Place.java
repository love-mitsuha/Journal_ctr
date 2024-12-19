package com.ahu21.pojo;

public class Place {
    private String PLACE;

    public String getPLACE() {
        return PLACE;
    }

    public void setPLACE(String PLACE) {
        this.PLACE = PLACE;
    }

    @Override
    public String toString() {
        return "Place{" +
                "PLACE='" + PLACE + '\'' +
                '}';
    }
}
