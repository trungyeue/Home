package com.example.home.mode;

public class Im {

    private String phong;
    private int id;

    public Im(String phong, int id) {
        this.phong = phong;
        this.id = id;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Im{" +
                "phong='" + phong + '\'' +
                ", id=" + id +
                '}';
    }
}

