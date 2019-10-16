package com.example.home.mode;

public class Departurea {

    String guestName;
    private String roomType;
    private String arrival;
    private String departure;
    String roomName;
    private String departureTime;
    private String source;
    private String folioNo;
    private  int  adult;
    private int child;
    private int nights;
  private int roomCharge;

    public Departurea(String guestName, String roomType, String arrival, String departure, String roomName, String departureTime, String source, String folioNo, int adult, int child, int nights, int roomCharge) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.arrival = arrival;
        this.departure = departure;
        this.roomName = roomName;
        this.departureTime = departureTime;
        this.source = source;
        this.folioNo = folioNo;
        this.adult = adult;
        this.child = child;
        this.nights = nights;
        this.roomCharge = roomCharge;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFolioNo() {
        return folioNo;
    }

    public void setFolioNo(String folioNo) {
        this.folioNo = folioNo;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public int getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(int roomCharge) {
        this.roomCharge = roomCharge;
    }
}
