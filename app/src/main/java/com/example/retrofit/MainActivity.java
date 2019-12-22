package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
        // Buoc 1: Khoi tao retrofit
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://khoapham.vn/KhoaPhamTraining/json/tien/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    /// Buoc 2: Tao interface request
     ApiRequest apiRequest= retrofit.create(ApiRequest.class);
     ///Buoc 3: gui request va nhan ve call back
        Call< List<Demo4>> callback= apiRequest.getDemo4();
        callback.enqueue(new Callback<List<Demo4>>() {
            @Override
            public void onResponse(Call< List<Demo4>> call, Response< List<Demo4>> response) {
                List<Demo4> object= response.body();

                for(Demo4 s: object) {
                    Log.d("BBB",s.getKhoahoc());
                    Log.d("BBB",s.getHocphi());
                }

            }

            @Override
            public void onFailure(Call< List<Demo4>> call, Throwable t) {
                Log.d("BBB",t.getMessage());
            }


        });
    }
}
