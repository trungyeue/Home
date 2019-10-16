package com.example.home.mode;

public class DaTaHome {
    private  String roomId;
    private String roomName;
    private  String roomTypeId;

    public DaTaHome(String roomId, String roomName, String roomTypeId) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomTypeId = roomTypeId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
}
