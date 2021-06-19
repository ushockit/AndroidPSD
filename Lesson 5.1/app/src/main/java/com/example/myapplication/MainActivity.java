package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.api.services.datanews.DataNewsService;
import com.example.myapplication.api.services.datanews.models.DataNewResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.datanews.io/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        DataNewsService dataNewsService = retrofit.create(DataNewsService.class);
        dataNewsService.getNews("SpaceX", "2020-07-01").enqueue(new Callback<DataNewResponse>() {
            @Override
            public void onResponse(Call<DataNewResponse> call, Response<DataNewResponse> response) {
                DataNewResponse body = response.body();
                int a = 0;
            }

            @Override
            public void onFailure(Call<DataNewResponse> call, Throwable t) {
                int a = 0;
            }
        });

        imageView.setOnClickListener(v -> {

        });

    }
}