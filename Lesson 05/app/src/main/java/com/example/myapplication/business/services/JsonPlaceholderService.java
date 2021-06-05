package com.example.myapplication.business.services;

import com.example.myapplication.business.dto.CommentDTO;
import com.example.myapplication.business.dto.UserDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceholderService {
    @GET("/users")
    Call<List<UserDTO>> getAllUsers();

//    @GET("/posts/{id}/comments")
//    Call<List<CommentDTO>> getCommentsForPost(@Path("id") int postId);

    @GET("/comments")
    Call<List<CommentDTO>> getCommentsForPost(@Query("postId") int postId);

}
