package com.example.retrofit;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("demo1.json")
    Call<Demo1> getDemo1();
    @GET("demo2.json")
    Call<Demo2> getDemo2();
    @GET("demo3.json")
    Call<DEMO3> getDemo3();
}
