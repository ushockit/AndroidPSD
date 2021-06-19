package com.example.myapplication.api.services.datanews;


import com.example.myapplication.api.services.datanews.models.DataNewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface DataNewsService {
    @Headers("x-api-key: 0jl8nitkc6ty9juddyg8lkrlc")
    @GET("v1/news")
    Call<DataNewResponse> getNews(@Query("q") String query, @Query("from") String dateFrom);
}
