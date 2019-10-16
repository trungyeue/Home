package com.example.home;

import com.example.home.mode.DaTaHome;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface {
    String JSONURL = "http://extranet.sophiapms.com/api/";

    @GET("RoomType/4")
    Call<List<DaTaHome>> getDataString();
}


