package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        Call<Demo2> callback= apiRequest.getDemo2();
        callback.enqueue(new Callback<Demo2>() {
            @Override
            public void onResponse(Call<Demo2> call, Response<Demo2> response) {
                Demo2 object= response.body();
                List<Danhsach> temp= object.getDanhsach();
                int i=0;
                for (Danhsach s: temp) {
                    Log.d("BBB",s.getKhoahoc());
                }

            }

            @Override
            public void onFailure(Call<Demo2> call, Throwable t) {

            }


        });
    }
}
