package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.people.PeopleContent;

public class MainActivity extends AppCompatActivity implements PeopleListFragment.OnPeopleListFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemSelect(PeopleContent.PersonItem person) {
        Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();
        PersonInfoFragment personInfoFragment = (PersonInfoFragment) getSupportFragmentManager().findFragmentById(0);
        personInfoFragment.setData(person);
    }
}