package com.example.home.mode;

public class Revenuea {
   String Name;
    private  int change;
    private  int night;
    private  int rate;

    public Revenuea(String name, int change, int night, int rate) {
        this.Name = name;
        this.change = change;
        this.night = night;
        this.rate = rate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
