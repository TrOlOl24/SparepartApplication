package com.example.sparepartapplication.API;

import com.example.sparepartapplication.Room.SparePart;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SparePartApi {

    @GET("/get-all")
    Call<List<SparePart>>getAll();
}
