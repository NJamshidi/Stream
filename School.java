package com.school;

public class School {
    private String name;
    private int degree; // درجه بندی مدرسه که بیانگر کیفیت مدرسه می باشد و  میتواند مقادیر ۱و۲و۳ باشد

    public School(String name, int degree) {
        this.name = name;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
