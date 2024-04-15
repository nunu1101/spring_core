package com.ohgiraffers.common;

import java.util.Date;

public class Bread extends Product{

    private java.util.Date bakedDate;   // 생산시간

    public Bread(){
        super();
    }

    public Bread(String name, int price, Date bakedDate) {
        super(name, price);
        this.bakedDate = bakedDate;
    }

    public java.util.Date getBakedDate() {
        return this.bakedDate;
    }

    public void setBakedDate(java.util.Date bakedDate) {
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        return super.toString() + " " + bakedDate;
    }
}
