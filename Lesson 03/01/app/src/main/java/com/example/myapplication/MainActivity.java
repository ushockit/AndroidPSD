package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.adapters.PeopleAdapter;
import com.example.myapplication.models.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PeopleAdapter.OnPeopleAdapterListener {
    private final int ADD_PERSON_REQUEST_CODE = 1;

    static List<Person> people = new ArrayList<>();
    static {
        people.add(new Person("First name 1","Last name 1",LocalDate.parse("2011-05-12"),"https://www.pngkit.com/png/detail/4-41931_the-boss-baby-png-image-background-boss-baby.png"));
        people.add(new Person("First name 2", "Last name 2", LocalDate.now(), "https://www.pngkit.com/png/detail/4-41931_the-boss-baby-png-image-background-boss-baby.png"));
        people.add(new Person("First name 3", "Last name 3", LocalDate.now(), "https://www.pngkit.com/png/detail/4-41931_the-boss-baby-png-image-background-boss-baby.png"));
        people.add(new Person("First name 4", "Last name 4", LocalDate.now(), "https://www.pngkit.com/png/detail/4-41931_the-boss-baby-png-image-background-boss-baby.png"));people.add(new Person("First name 1", "Last name 1", LocalDate.now(), "https://www.pngkit.com/png/detail/4-41931_the-boss-baby-png-image-background-boss-baby.png"));
        people.add(new Person("First name 5", "Last name 5", LocalDate.now(), "https://www.pngkit.com/png/detail/4-41931_the-boss-baby-png-image-background-boss-baby.png"));

    }

    RecyclerView rvPeople;
    PeopleAdapter peopleAdapter;
    Button btnCreatePerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPeople = findViewById(R.id.rvPeople);
        btnCreatePerson = findViewById(R.id.btnCreatePerson);

        peopleAdapter = new PeopleAdapter(this, people);
        rvPeople.setAdapter(peopleAdapter);


        //клик "Create person"
        btnCreatePerson.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddPersonActivity.class);
            startActivityForResult(intent, ADD_PERSON_REQUEST_CODE);
        });

    }

    @Override
    public void onViewClick(Person person, int position) {
        // Toast.makeText(this, "View person click: " + person.getFirstName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ViewPersonActivity.class);
        intent.putExtra(Person.class.getSimpleName(), person);
        startActivity(intent);
    }

    @Override
    public void onEditClick(Person person, int position) {
        Toast.makeText(this, "Edit person click: " + person.getFirstName(), Toast.LENGTH_SHORT).show();
        person.setFirstName("Edited_" + person.getFirstName());
        peopleAdapter.notifyItemChanged(position);
    }

    @Override
    public void onRemoveClick(Person person, int position) {
        Toast.makeText(this, "Remove person click: " + person.getFirstName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case ADD_PERSON_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    Person person = (Person) data.getExtras().getSerializable(Person.class.getSimpleName());
                    people.add(person);
                    peopleAdapter.notifyDataSetChanged();
                }
                break;
        }
    }
}