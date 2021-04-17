package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnWelcome, btnHello;
    Button btnA, btnB, btnC, btnD;
    TextView tvText;
    EditText etText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWelcome = findViewById(R.id.btnWelcome);
        btnHello = findViewById(R.id.btnHello);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        tvText = findViewById(R.id.tvText);
        etText = findViewById(R.id.etText);

        // 2ой способ привязки обработчика
        btnHello.setOnClickListener(v -> {
            tvText.setText("Hello");
        });

        // 3ий способ привязки обработчика
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);


        etText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvText.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    // 1ый вариант привязки обработчика (через onClick в xml)
    public void onBtnWelcomeClick(View v) {
        tvText.setText("Welcome");
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnA:
                Toast toast = Toast.makeText(this, "A", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.btnB:
                Toast.makeText(this, "B", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnC:
                Toast.makeText(this, "C", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnD:
                Toast.makeText(this, "D", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tvText", tvText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        tvText.setText(savedInstanceState.getString("tvText"));
    }
}