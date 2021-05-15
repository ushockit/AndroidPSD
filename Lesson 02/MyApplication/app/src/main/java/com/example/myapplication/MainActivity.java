package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.myapplication.adapters.PeopleAdapter;
import com.example.myapplication.models.Person;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnShowSnackbar;
    ImageView imageView;
    ToggleButton toggleButton;
    RadioGroup radioGroup;
    SeekBar seekBar;
    TextView textView;
    TimePicker timePicker;
    ListView lvItems;

    List<Person> people = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowSnackbar = findViewById(R.id.btnShowSnackbar);
        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);
        toggleButton = findViewById(R.id.toggleButton);
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);
        timePicker = findViewById(R.id.timePicker);
        lvItems = findViewById(R.id.lvItems);

        btnShowSnackbar.setOnClickListener(v -> {
            Snackbar snackbar = Snackbar.make(MainActivity.this, v, "Hello world", Snackbar.LENGTH_LONG);

            snackbar.show();
        });

        // imageView.setImageResource(R.drawable.voda);
//        InputStream is = null;
//        try {
//            is = getApplicationContext().getAssets().open("voda.png");
//            Drawable drawable = Drawable.createFromStream(is, null);
//            imageView.setImageDrawable(drawable);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        radioGroup.setOnCheckedChangeListener(this::onCheckedChangedRadio);
        toggleButton.setOnClickListener(v -> {

        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            }
        });
        // работа со списком строк
//        ArrayList<String> items = new ArrayList<>();
//        items.add("Item 1");
//        items.add("Item 2");
//        items.add("Item 3");
//        items.add("Item 4");
//        items.add("Item 5");
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
//        lvItems.setAdapter(adapter);
//
//        lvItems.setOnItemClickListener((parent, view, position, id) -> {
//            Toast.makeText(this, items.get(position), Toast.LENGTH_SHORT).show();
//        });
//
//        lvItems.setOnItemLongClickListener((parent, view, position, id) -> {
//            items.remove(position);
//            // уведомление об изменениях в списке
//            adapter.notifyDataSetChanged();
//            return true;
//        });

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("First name 1", "Last name 1", 20, "https://pngimg.com/uploads/mario/mario_PNG53.png"));
        people.add(new Person("First name 2", "Last name 2", 22, "https://avatanplus.ru/files/resources/original/57a726e809c0715664effa68.png"));
        people.add(new Person("First name 3", "Last name 3", 19, "https://lh3.googleusercontent.com/proxy/p9QRbP7D2po6SF4uFpmHKuAxuEsH1qO3mD3XhTXbAQOf1_rg7sSGlUj_KS3ML2k5ClXACHOsz5I-V7BbxoyUxiFZHbs7AKI"));


        PeopleAdapter adapter = new PeopleAdapter(this, R.layout.person_layout, people);
        lvItems.setAdapter(adapter);

    }


    public void onCheckboxClick(View v) {
        CheckBox checkBox = (CheckBox)v;
        Snackbar.make(this, v, checkBox.isChecked() ? "checked" : "unchecked", Snackbar.LENGTH_SHORT).show();
    }

    public void onCheckedChangedRadio(RadioGroup group, int id) {
        RadioButton rb = findViewById(id);
        Toast.makeText(this, rb.getText(), Toast.LENGTH_SHORT).show();
//        switch(id) {
//            case R.id.rb1:
//                Toast.makeText(this, rb.getText(), Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.rb2:
//                Toast.makeText(this, rb.getText(), Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.rb3:
//                Toast.makeText(this, rb.getText(), Toast.LENGTH_SHORT).show();
//                break;
//        }
    }
}