package com.bas.bac_a_sable_recyclerview_callback;

public class MyObject {
    private String text;
    private Integer integer;

    public MyObject(String text, Integer integer) {
        this.text = text;
        this.integer = integer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
