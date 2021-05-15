package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.models.Person;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PeopleAdapter extends ArrayAdapter<Person> {
    private LayoutInflater inflater;
    private List<Person> people;
    private int resource;

    public PeopleAdapter(@NonNull Context context, int resource, List<Person> people) {
        super(context, resource, people);
        this.people = people;
        this.inflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource, parent, false);


        TextView tvFirstName = view.findViewById(R.id.tvFirstName);
        TextView tvLastName = view.findViewById(R.id.tvLastName);
        TextView tvAge = view.findViewById(R.id.tvAge);
        ImageView imageView = view.findViewById(R.id.imgViewUserPhoto);

        Person person = people.get(position);

        tvFirstName.setText(person.getFirstName());
        tvLastName.setText(person.getLastName());
        tvAge.setText(String.valueOf(person.getAge()));

        Picasso.get().load(person.getImagePath()).into(imageView);

        Button btnRemove = view.findViewById(R.id.btnRemovePerson);

        btnRemove.setOnClickListener(v -> {
            people.remove(person);
            notifyDataSetChanged();
        });

        return view;
    }
}
