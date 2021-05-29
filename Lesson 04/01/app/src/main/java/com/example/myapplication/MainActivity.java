package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowFragment = findViewById(R.id.btnShowFragment);

        btnShowFragment.setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_view, UserInfoFragment.class, null, "USER_INFO_TAG")
                    .commit();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.add(0, 1, 1, "Item 1");
        menu.add(0, 2, 2, "Item 2");
        menu.add(0, 3, 3, "Item 3");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch(id) {
//            case R.id.menu_item_1:
//                Toast.makeText(this, "Выбран первый пункт меню", Toast.LENGTH_SHORT).show();
//                break;
            case 1:
                Toast.makeText(this, "Выбран первый пункт меню", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}