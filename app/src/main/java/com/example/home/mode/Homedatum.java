package com.example.home.mode;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Homedatum {

    @SerializedName("roomTypeId")
    @Expose
    private Integer roomTypeId;
    @SerializedName("roomTypeName")
    @Expose
    private String roomTypeName;
    @SerializedName("rooms")
    @Expose
    private String rooms;

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String id) {
        this.rooms = rooms;
    }

}