package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.models.Person;
import com.squareup.picasso.Picasso;

public class ViewPersonActivity extends AppCompatActivity {
    TextView tvFirstName, tvLastName, tvBirth;
    ImageView ivPhoto;
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_person);

        ivPhoto = findViewById(R.id.ivPhoto);
        tvFirstName = findViewById(R.id.tvFirstName);
        tvLastName = findViewById(R.id.tvLastName);
        tvBirth = findViewById(R.id.tvBirth);


        Bundle bundle = getIntent().getExtras();
        person = (Person) bundle.getSerializable(Person.class.getSimpleName());

        loadData();

    }

    private void loadData() {
        Picasso.get().load(person.getImagePath()).into(ivPhoto);
        tvFirstName.setText(person.getFirstName());
        tvLastName.setText(person.getLastName());
        tvBirth.setText(person.getBirth().toString());
    }
}