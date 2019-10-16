package com.example.home.mode;

import android.annotation.SuppressLint;
import android.os.Parcel;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

@SuppressLint("ParcelCreator")
public class InHomea {
    private String roomType;
   String romName;
    String guestName;
    private int roomRate;
    private String arrival;
    private String departure;
    private int nights;
    private String folioNo;
    private String source;
    private int Child;
    private int adult;
    private int balance;

    public InHomea(String roomType, String romName, String guestName, int roomRate, String arrival, String departure, int nights, String folioNo, String source, int child, int adult,int balance) {
        this.roomType = roomType;
        this.romName = romName;
        this.guestName = guestName;
        this.roomRate = roomRate;
        this.arrival = arrival;
        this.departure = departure;
        this.nights = nights;
        this.folioNo = folioNo;
        this.source = source;
        this.Child = child;
        this.adult = adult;
        this.balance=balance;

    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return Child;
    }

    public void setChild(int child) {
        Child = child;
    }

    public String getfolioNo() {
        return folioNo;
    }

    public void setfolioNo(String folioNo) {
        this.folioNo = folioNo;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }


    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRomName() {
        return romName;
    }

    public void setRomName(String romName) {
        this.romName = romName;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(int roomRate) {
        this.roomRate = roomRate;
    }

    public String getFolioNo() {
        return folioNo;
    }

    public void setFolioNo(String folioNo) {
        this.folioNo = folioNo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


}
