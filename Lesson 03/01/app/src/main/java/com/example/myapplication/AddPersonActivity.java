package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.models.Person;

import java.time.LocalDate;

public class AddPersonActivity extends AppCompatActivity {
    EditText etFirstName, etLastName, etBirth, etPhoto;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etBirth = findViewById(R.id.etBirth);
        etPhoto = findViewById(R.id.etPhoto);
        btnSave = findViewById(R.id.btnSave);

        // клик по кнопке "Save"
        btnSave.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(Person.class.getSimpleName(), new Person(
                    etFirstName.getText().toString(),
                    etLastName.getText().toString(),
                    LocalDate.parse(etBirth.getText().toString()),
                    etPhoto.getText().toString()
            ));
            setResult(RESULT_OK, intent);
            // закрытие Activity
            finish();
        });
    }
}