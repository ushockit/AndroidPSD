package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.example.myapplication.business.dto.CommentDTO;
import com.example.myapplication.business.dto.UserDTO;
import com.example.myapplication.business.services.JsonPlaceholderService;
import com.example.myapplication.database.entity.Person;
import com.orm.SugarContext;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    // https://blog.mindorks.com/getting-started-with-lottie-animation-in-android
    // https://www.jsonschema2pojo.org/
    // https://lottiefiles.com/
    // https://github.com/airbnb/lottie-android
    // https://square.github.io/retrofit/
    Button btnPlay, btnForAnim, btnStop;
    LottieAnimationView animView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SugarContext.init(this);

        btnPlay = findViewById(R.id.btn);
        btnStop = findViewById(R.id.btnStop);
        btnForAnim = findViewById(R.id.btnForAnim);
        animView = findViewById(R.id.lav_main);


        btnPlay.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
            btnForAnim.startAnimation(animation);

            animView.playAnimation();
            animView.setVisibility(View.VISIBLE);
        });

        btnStop.setOnClickListener(v -> {
            animView.cancelAnimation();
            animView.setVisibility(View.INVISIBLE);
        });


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com//")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholderService jsonPlaceholderService = retrofit.create(JsonPlaceholderService.class);

//        jsonPlaceholderService.getAllUsers().enqueue(new Callback<List<UserDTO>>() {
//            @Override
//            public void onResponse(Call<List<UserDTO>> call, Response<List<UserDTO>> response) {
//                List<UserDTO> users = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<List<UserDTO>> call, Throwable t) {
//            }
//        });

//        jsonPlaceholderService.getCommentsForPost(1).enqueue(new Callback<List<CommentDTO>>() {
//            @Override
//            public void onResponse(Call<List<CommentDTO>> call, Response<List<CommentDTO>> response) {
//                List<CommentDTO> comments = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<List<CommentDTO>> call, Throwable t) {
//            }
//        });

//        Person person = new Person("Vasya", "Pupkin", LocalDate.now().atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli());
//        person.save();

        Person p = Person.findById(Person.class, 1);


    }
}